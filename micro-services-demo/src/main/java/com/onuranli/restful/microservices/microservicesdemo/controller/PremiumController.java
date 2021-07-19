package com.onuranli.restful.microservices.microservicesdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.onuranli.restful.microservices.microservicesdemo.bean.Premium;
import com.onuranli.restful.microservices.microservicesdemo.configuration.Configuration;

@RestController
public class PremiumController {
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/getPremium")
	public Premium getPremium(){
//		return new Premium(5, 10, 15, 20);
		return new Premium(configuration.getNetPremium(),configuration.getGrossPremium(),configuration.getMaxPremium(),configuration.getMinPremium());
	}
}
