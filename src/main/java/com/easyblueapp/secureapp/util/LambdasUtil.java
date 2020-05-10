package com.easyblueapp.secureapp.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.mongodb.lang.Nullable;

public class LambdasUtil {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.out.println(getSumDoubleTotal());
		//System.out.println(getShowingLines());
		//getStringList();
		getNewList();
//		getBooksvsLines();
//		getMapByNameAgeListPeople();
//		getMapTotalAgeByNameListPeople();
//		getMapTotalByNameListPeople();
//		getPeoppleOrderByPoints();
//		getTotalPointsFromPerson();
		System.out.println("--------------");
		getPeopleTrx();
		System.out.println("--------------");
		getListPeopleTrx();
		System.out.println("--------------");
		getCategoriesEnum();
	}
	
	
	private static void getNewList(){
		TransactionCommentsCountDS t = new TransactionCommentsCountDS("tri8kmbwjqtqqqtis2lv", 0);
		TransactionCommentsCountDS t1 = new TransactionCommentsCountDS("trmtjrxodsb4uepzoxg6", 0);
		TransactionCommentsCountDS t2 = new TransactionCommentsCountDS(null, 0);
		List<TransactionCommentsCountDS> listT = new ArrayList<>();
		listT.add(t);
		listT.add(t1);
		listT.add(t2);
		
		List<Optional<String>> list = listT.stream()
				.map(TransactionCommentsCountDS::getTransactionId)
				.collect(Collectors.toList());
		
		list.forEach(l -> 
				System.out.println(l.orElse("")));

		List<String> res =listT.stream()
				.map(TransactionCommentsCountDS::getTransactionId)
				.collect(Collectors.toList()) //List<Optional<String>>
				.stream()
				.map(s -> s.orElse(""))
				.collect(Collectors.toList()) //List<String>
				.stream()
				.filter(s -> s.toLowerCase()
				.contains("tri8kmbwjqtqqqtis2lv"))
				.collect(Collectors.toList()); //List<String>
			
		
		res.forEach(System.out::println);
		
		//return list;
	}
	
	private static List<String> getStringList(){
		List<String> list = Arrays.asList("Juan", "Luis");
		
		list.forEach(s -> System.out.println(s));

		List<String> res =list.stream().filter(s -> s.toLowerCase()
				.contains("luis"))
				.collect(Collectors.toList());
		
		res.forEach(System.out::println);
		
		return list;
	}
	
	//Get Map from Stream<String>
	private static Map<String, Integer> getShowingLines(){
		Map<String, Integer> rowsMap = null;
		try {
			Stream<String> rows3 = Files.lines(Paths.get("/Users/pablogonzalez/workspace_help/be/EasyBlueApp/src/main/java/com/easyblueapp/secureapp/util/data.txt"));
			rowsMap = new HashMap<>();
			
//			rows3.map(r -> r.split(",")).filter(r-> r.length==3).forEach(r->{
//				System.out.println(Integer.parseInt(r[1]));
//			});
			
			rowsMap = rows3.map(r -> r.split(","))
					.filter(r -> r.length ==4)  // r[0]= G , r[1]= 50, r[2]=9.1, r[3]=34
					.filter(r -> Integer.parseInt(r[1])>15)
					.collect(Collectors.toMap(
							r -> r[0], 
							r-> Integer.parseInt(r[1])));
			
			rows3.close();
			
			for(String key: rowsMap.keySet()) {
				System.out.println(key + "  " + rowsMap.get(key));
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rowsMap;
	}
	
	//Get Map from Stream<String>
		private static void getBooksvsLines(){
			
			try {
				Stream<String> rows3 = Files.lines(Paths.get("/Users/pablogonzalez/workspace_help/be/EasyBlueApp/src/main/java/com/easyblueapp/secureapp/util/bands.txt"));
				
				List<Bands> rows  = rows3.map(r -> r.split(","))   // Stream of [] Strings
						.filter(r -> Integer.parseInt(r[0].trim()) >=4) // Stream of [] of String
						.map(r->{   //Stream<Object>
							Bands b = new Bands();
							b.setId(Integer.parseInt(r[0].trim()));
							b.setName(r[1]);
							return b; 
						})
						.collect(Collectors.toList());
				
				rows.stream().forEach(b-> {
						System.out.println(b.getId() +" - "+b.getName());
					});
			
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	
	
	//Gets Sum from double array list
	private static double getSumDoubleTotal() {
		
		return getDoubleList().stream().reduce(0.0, (Double a, Double b) -> a + b);
	}
	
	
	
	
	private static List<Double> getDoubleList(){
		List<Double> list = new ArrayList<Double>();
		list.add(10.3);
		list.add(7.3);
		list.add(1.5);
		list.add(4.8);
		return list;
	}
	
	private static List<Person> cratePeople(){
		List<Person> list = new ArrayList<Person>();
		list.add(new Person(20, "Sara", 500));
		list.add(new Person(22, "Sara", 600));
		list.add(new Person(20, "Bob", 650));
		list.add(new Person(32, "Paula", 450));
		list.add(new Person(32, "Paul", 480));
		list.add(new Person(3, "Jack", 501));
		list.add(new Person(11, "Jill", 503));
		
		return list;
				
	}
	
	private static void getMapByNameAgeListPeople() {
	    final List<Person> people = cratePeople();
		Map<String, List<Integer>> ageByName = people.stream().
				collect(Collectors.groupingBy(Person::getName, Collectors.mapping(Person::getAge, Collectors.toList())));
		
		System.out.println(ageByName);
	}
	
	private static void getMapTotalAgeByNameListPeople() {
	    final List<Person> people = cratePeople();
		// Compute sum of salaries by department
	    Map<String, Integer> totalByName
	        = people.stream()
	                   .collect(Collectors.groupingBy(Person::getName,
	                                                  Collectors.summingInt(Person::getAge)));
	    System.out.println(totalByName);
	}
	
	private static void getMapTotalByNameListPeople() {
	    final List<Person> people = cratePeople();
		// Compute sum of salaries by department
	    Map<String, List<Person>> totalByName
	        = people.stream()
	                   .collect(Collectors.groupingBy(Person::getName));
	    
	    for(String name : totalByName.keySet()) {
	    	System.out.println(name);
	    	totalByName.get(name).stream().forEach(e -> System.out.println(e.getName() +"- "+e.getAge()));
	    }
	}
	
	public static void getPeoppleOrderByPoints(){
		final List<Person> people = cratePeople();
		Map<String, List<Integer>> res = people.stream()
		.filter(p -> p.getPoints() != null)
		.collect(Collectors.groupingBy(Person :: getName, Collectors.mapping(Person::getPoints, Collectors.toList())));
		System.out.println(res);
		
		res.entrySet().stream()
		.map(Entry :: getValue)
		.collect(Collectors.toList())
		.forEach(System.out::println);
		
		res.entrySet().stream()
		.forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
		
		res.entrySet().stream()
		.filter(e->e.getKey().contains("Sara"))
		.forEach(e -> System.out.println(e.getKey() + ":" + e.getValue()));
		
		List<List<Integer>> newIntegers = res.entrySet()
		.stream()
		.map(Entry::getValue)
		.collect(Collectors.toList());
		
		
	}
	
	public static void getTotalPointsFromPerson(){
		final List<Person> people = cratePeople();
		//Map<String, Integer> res = 
		Integer res = people.stream()
		.filter(p -> p.getPoints() != null)
		.map(Person :: getPoints) //Stream<Integer>
		.reduce(0, (total, points)-> total + points);
		System.out.println(res);
	}
	
	public static void getPeopleTrx() {
		Person people = new Person(20, "Sara", 500);
		people.setTr(null);
		String id = people.getTr()
				.flatMap(TransactionCommentsCountDS::getTransactionId).orElse("unknown");
		System.out.println("ID: "+id);	
	}
	
	public static void getListPeopleTrx() {
		TransactionCommentsCountDS t = new TransactionCommentsCountDS("tri8kmbwjqtqqqtis2lv", 1);
		TransactionCommentsCountDS t1 = new TransactionCommentsCountDS("trmtjrxodsb4uepzoxg6", 2);
		TransactionCommentsCountDS t2 = new TransactionCommentsCountDS(null, 3);
		List<TransactionCommentsCountDS> listT = new ArrayList<>();
		listT.add(t);
		listT.add(t1);
		listT.add(t2);
		listT.add(null);
		
		Person people = new Person(20, "Sara", 500);
		people.setTrs(listT);
		
		List<TransactionCommentsCountDS> trs = 
				people.getTrs().orElse(new ArrayList<>());// List<TransactionCommentsCountDS> is null , then new ArrayList<>()
		
		List<String> ids =trs.stream()
				.filter(tr-> tr !=null) // Only TransactionCommentsCountDS != null
				.collect(Collectors.toList())  //new List<TransactionCommentsCountDS> not Empty
				.stream()
				.map(s -> s.getTransactionId().orElse("unknown"))  // new List<String> of TransactionCommentsCountDS.getTransactionId is null, then unknown
				.collect(Collectors.toList());
		
		ids.forEach(System.out::println);
				
	}
	
	
	public static void getCategoriesEnum() {
		EnumCatsKeys.APPLE.getBrandsCategories().orElse(new HashMap<String, List<String>>())
		.entrySet()
		.stream()
		.forEach(e -> System.out.println(e.getKey() +"-"+ e.getValue()));	
		
		EnumCatsKeys.WIN.getBrandsCategories().orElse(new HashMap<String, List<String>>())
		.entrySet()
		.stream()
		.forEach(e -> System.out.println(e.getKey() +"-"+ e.getValue()));
		
		System.out.println(EnumCatsKeys.BRAND_APPLE.getBrand().orElse(""));
		System.out.println(EnumCatsKeys.BRAND_WIN.getBrand().orElse(""));
	}
	
	public static class TransactionCommentsCountDS {
		  @Nullable
		  String transactionId;
		  
		  @Nullable
		   Integer count;
		   
		   public TransactionCommentsCountDS(String transactionId, Integer count) {
			super();
			this.transactionId = transactionId;
			this.count = count;
		}

		public Optional<String> getTransactionId() {
			return Optional.ofNullable(transactionId);
		}

		public void setTransactionId(String transactionId) {
			this.transactionId = transactionId;
		}

		public Integer getCount() {
			return count;
		}

		public void setCount(Integer count) {
			this.count = count;
		}	
	}
	
	public static class Bands{
		private Integer id;
		private String name;
		
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
	}
	
	public static class Person{
		private Integer age; 
		private String name;
		private Integer points;
		private TransactionCommentsCountDS tr;
		private List<TransactionCommentsCountDS> trs;
		
		
		public Person(Integer age, String name, Integer points) {
			super();
			this.age = age;
			this.name = name;
			this.points = points;
		}
		public Integer getPoints() {
			return points;
		}
		public void setPoints(Integer points) {
			this.points = points;
		}
		public Person(Integer age, String name) {
			super();
			this.age = age;
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public Optional<TransactionCommentsCountDS> getTr() {
			return Optional.ofNullable(tr);
		}
		public void setTr(TransactionCommentsCountDS tr) {
			this.tr = tr;
		}
		
		public Optional<List<TransactionCommentsCountDS>> getTrs() {
			return Optional.ofNullable(trs);
		}
		public void setTrs(List<TransactionCommentsCountDS> trs) {
			this.trs = trs;
		}
	}

}
