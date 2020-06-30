package com.easyblueapp.secureapp.util;

import java.util.*;
import java.util.stream.*;

public class MapVsFlatMap {
	
	static List<Integer> numbers = Arrays.asList(1, 2, 3);

	public static void main(String[] args) {
		
//		System.out.println(getDouble());
//		readListOfList();
//		readStreamListOfList();
		readStreamBeforeAndAfter2();
	}
	
	public static Double getDouble(){
		 return numbers.stream()
			      .map(e -> e * 2.0)
			      .collect(Collectors.summingDouble(MapVsFlatMap::getSum));
		 
	}
	
	private static Double getSum(double val) {
		return val;
	}
	
	public static List<List<Integer>> getListInteger(){
		return numbers.stream()
			      .map(e -> Arrays.asList(e - 1, e + 1))
			      .collect(Collectors.toList());
	}
	
	public static void readListOfList() {
		getListInteger().
		stream().
		forEach(e-> e.stream().forEach(System.out::println));
	}
	
	public static Stream<List<Integer>> getStreamListInteger(){
		return numbers.stream()
			      .map(e -> Arrays.asList(e - 1, e + 1));
	}
	
	public static void readStreamListOfList() {
		getStreamListInteger().forEach(System.out::println);
	}
	
	public static Stream<Integer> beforeAndAfter2(){
		return numbers.stream()
			      .flatMap(e -> Arrays.asList(e - 1, e + 1).stream());
	}
	
	public static void readStreamBeforeAndAfter2() {
		beforeAndAfter2().forEach(System.out::println);
	}

}
