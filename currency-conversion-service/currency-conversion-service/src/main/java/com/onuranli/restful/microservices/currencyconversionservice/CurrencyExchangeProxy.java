package com.onuranli.restful.microservices.currencyconversionservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "currency-exchange", url = "localhost:8000") /*spring.application.name=currency-exchange*/
public interface CurrencyExchangeProxy {
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion retrieveExhange(@PathVariable("from") String from, @PathVariable("to") String to);/*Currency exchange controllerdan aldım*/
}
