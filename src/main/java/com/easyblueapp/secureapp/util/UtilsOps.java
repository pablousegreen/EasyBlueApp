package com.easyblueapp.secureapp.util;

public class UtilsOps {
	
	public static int divide(int value, int factor) {
	    int result = 0;
	    try {
	        result = value / factor;
	    } catch (ArithmeticException e) {
	        System.out.println("Arithmetic Exception: Division by Zero");
	    }
	    return result;
	}

}
