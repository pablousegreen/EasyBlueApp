package com.easyblueapp.secureapp.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import io.reactivex.Observable;

public class SampleObservable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	   List<String> symbols = new ArrayList<>();
	   
	   symbols = Arrays.asList("GOOD", "NICE", "WHATEVER", "hulk").stream()
	   .collect(Collectors.toList());
	   
	   Observable<StockInfo> feed = StockServer.getFeed(symbols); 
	   
	   System.out.println("Got the observable...");
	   
	   feed.subscribe(stockInfo -> 
	   System.out.println(stockInfo.getTheInfo() + " : "+stockInfo.getTheValue()));
	}

}
