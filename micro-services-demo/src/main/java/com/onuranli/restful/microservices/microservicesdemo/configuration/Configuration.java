package com.onuranli.restful.microservices.microservicesdemo.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("microservices-demo")
public class Configuration {

	private int netPremium; 
	private int grossPremium;
	private int maxPremium;
	private int minPremium;
	
	public int getNetPremium() {
		return netPremium;
	}
	public void setNetPremium(int netPremium) {
		this.netPremium = netPremium;
	}
	public int getGrossPremium() {
		return grossPremium;
	}
	public void setGrossPremium(int grossPremium) {
		this.grossPremium = grossPremium;
	}
	public int getMaxPremium() {
		return maxPremium;
	}
	public void setMaxPremium(int maxPremium) {
		this.maxPremium = maxPremium;
	}
	public int getMinPremium() {
		return minPremium;
	}
	public void setMinPremium(int minPremium) {
		this.minPremium = minPremium;
	}
}
