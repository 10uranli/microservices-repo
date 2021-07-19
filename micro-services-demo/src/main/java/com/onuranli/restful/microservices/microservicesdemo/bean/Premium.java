package com.onuranli.restful.microservices.microservicesdemo.bean;

/**
 * @author Onur
 *
 */
public class Premium {

	private int netPremium; // Net prim
	private int grossPremium; // brüt prim
	private int maxPremium;
	private int minPremium;

	public Premium() {
		super();
	}

	public Premium(int netPremium, int grossPremium, int maxPremium, int minPremium) {
		super();
		this.netPremium = netPremium;
		this.grossPremium = grossPremium;
		this.maxPremium = maxPremium;
		this.minPremium = minPremium;
	}

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
