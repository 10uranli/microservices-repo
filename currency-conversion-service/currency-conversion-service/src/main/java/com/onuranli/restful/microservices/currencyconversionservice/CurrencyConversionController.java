package com.onuranli.restful.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {

	@Autowired
	private CurrencyExchangeProxy currencyExchangeProxy;

	@GetMapping("/currency-conversion/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculate(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		ResponseEntity<CurrencyConversion> currencyConversion = new RestTemplate().getForEntity(
				"http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConversion.class, uriVariables);
		/* Get yapacağız, object istiyoruz, variables geçeceğiz */
		CurrencyConversion body = currencyConversion.getBody();

		CurrencyConversion response = new CurrencyConversion(body.getId(), from, to, quantity,
				body.getConversionMultiple(), quantity.multiply(body.getConversionMultiple()), body.getEnv());
		return response;
	}

	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversion calculateWithFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal quantity) {
		CurrencyConversion currencyExchange = currencyExchangeProxy.retrieveExhange(from, to);
		/* Get yapacağız, object istiyoruz, variables geçeceğiz */
		return new CurrencyConversion(currencyExchange.getId(), from, to, quantity,
				currencyExchange.getConversionMultiple(), quantity.multiply(currencyExchange.getConversionMultiple()),
				currencyExchange.getEnv());
	}
}
