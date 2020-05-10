package com.easyblueapp.secureapp.util;

import java.util.List;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;

public class StockServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Observable<StockInfo> getFeed(List<String> symbols){
		
		System.out.println("Created ...");
		return Observable.create(emmiter -> emitPrice(emmiter, symbols));
		
	}

	private static void emitPrice(ObservableEmitter<StockInfo> emmiter, List<String> symbols) {
		// TODO Auto-generated method stub
		System.out.println("Ready to Emmiter ...");
		
		//while(true) {
			symbols.stream().map(StockInfo::fetch)
			.forEach(emmiter::onNext);
			//sleep(1000);			
		//}
		
		
	}
	
	private static void sleep(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}