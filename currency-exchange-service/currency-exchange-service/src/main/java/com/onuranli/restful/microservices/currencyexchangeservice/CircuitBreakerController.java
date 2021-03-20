package com.onuranli.restful.microservices.currencyexchangeservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircuitBreakerController {
	Logger log = LoggerFactory.getLogger(CircuitBreakerController.class);
	
	@GetMapping("/sample-api")
	@Retry(name = "sample-api", fallbackMethod = "defaultResponse")/*default name ile 3 kere yapar*/
	public String sampleApi(){
		log.info("Method sampleApi");
		ResponseEntity<String> forEntity = new RestTemplate().getForEntity("htpp://localhost:8080/olmayanAdres", String.class);
		return forEntity.getBody();
	}
	
	public String defaultResponse(Exception ex){
		return "Default Response!!";
		
	}
	
	@GetMapping("/getThreadInfo")
	@RateLimiter(name = "thread-api")
	public String getThreadInfo() {
		return "Name: " + Thread.currentThread().getName() + " isAlive: " + Thread.currentThread().isAlive();
	}
}
