package com.easyblueapp.secureapp.util.certification;

public class Variables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int moon = 9, star = 2 + 2 * 3;
		float sun = star>10 ? 1 : 3;
		double jupiter = (sun + moon) - 1.0f;
		int mars = --moon <= 8 ? 2 : 3; 
		System.out.println(sun+"-"+jupiter+"-"+mars);
		
		loopMain();
		
	}
	
	public static void Strings() {
		double tuesday = 5_6L;
		System.out.println("tuesday: " + tuesday);
		short thursday = (short)Integer.MAX_VALUE;
		System.out.println("thursday: " + thursday);
//		var s1 = "Java";
//		var s2 = "Java";
//		var s3 = "Ja".concat("va"); var s4 = s3.intern();
//		var sb1 = new StringBuilder(); sb1.append("Ja").append("va");
//		System.out.println(s1 == s2); System.out.println(s1.equals(s2)); System.out.println(s1 == s3); System.out.println(s1 == s4); System.out.println(sb1.toString() == s1); System.out.println(sb1.toString().equals(s1));
	}
	
	public static void loopMain() {
		int x = 5;
		int j = 0;
		OUTER: for (int i = 0; i < 3;)
		INNER: do { 
			i++;
			x++;
			if (x > 10) break INNER; 
			x += 4;
			j++;
		} while (j <= 2); 
		System.out.println(x);
	}
	

}
