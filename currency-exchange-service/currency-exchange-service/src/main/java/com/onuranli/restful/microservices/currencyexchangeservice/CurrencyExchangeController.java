package com.onuranli.restful.microservices.currencyexchangeservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment env;
	
	@Autowired
	private ExchangeRepository repository;
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyExchange retrieveExhange(@PathVariable String from, @PathVariable String to){
//		CurrencyExchange currencyExchange = new CurrencyExchange(1L,from, to, BigDecimal.valueOf(7));
		CurrencyExchange currencyExchange = repository.findByFromAndTo(from, to);
		if(currencyExchange == null){
			throw new RuntimeException("Unable to Find"+ from + " : " + to );
		}
		currencyExchange.setEnv(env.getProperty("server.port"));
		return currencyExchange;
	}
}
