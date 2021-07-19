package com.onuranli.restful.microservices.currencyexchangeservice;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ExchangeRepository extends JpaRepository<CurrencyExchange, Long>{
 
	CurrencyExchange findByFromAndTo(String from,String to); 
}
