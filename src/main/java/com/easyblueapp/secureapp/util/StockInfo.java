package com.easyblueapp.secureapp.util;

public class StockInfo {

	private String theInfo;
	private String theValue;
	
	
	public static StockInfo fetch(String ticker) {
		
		return new StockInfo(ticker, "5");
	}
	
	
	public StockInfo(String theInfo, String theValue) {
		super();
		this.theInfo = theInfo;
		this.theValue = theValue;
	}
	public String getTheInfo() {
		return theInfo;
	}
	public void setTheInfo(String theInfo) {
		this.theInfo = theInfo;
	}
	public String getTheValue() {
		return theValue;
	}
	public void setTheValue(String theValue) {
		this.theValue = theValue;
	}
	
	

}
