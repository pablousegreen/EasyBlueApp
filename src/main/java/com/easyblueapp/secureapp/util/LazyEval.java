package com.easyblueapp.secureapp.util;

import java.util.Arrays;
import java.util.List;

public class LazyEval {

	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8, 9, 10);
		
		System.out.println(
		numbers
		.stream()
		.filter(LazyEval::isGT3)
		.filter(LazyEval::isEven)
		.map(LazyEval::doubleIt)
		.findFirst()
		.orElse(0));
	}
	
	public static boolean isGT3(int n) {
		if(n > 3) {
			System.out.println("isGT3 " + n);
		}
	    return n > 3;
	}
	
	  public static boolean isEven(int n) {
		  if(n % 2 == 0) {
			  System.out.println("isEven " + n);
		  }
	    
	    return n % 2 == 0;
	  }
	
	  public static int doubleIt(int n) {
	    System.out.println("doubleIt " + n);    
	    return n * 2;
	  }

}
