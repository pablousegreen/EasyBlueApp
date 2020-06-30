package com.easyblueapp.secureapp.util;

import java.util.concurrent.CompletableFuture;

public class PromisesUtil {
	
	public static CompletableFuture<Integer> create(){
		return CompletableFuture.supplyAsync(() -> 2);
	}

	public static void main(String[] args) {
		
		create().thenAccept(data -> System.out.println(data))
		.thenRun(() -> System.out.println("Never dies"))
		.thenRun(()->System.out.println("Trully never dies"));

	}

}
