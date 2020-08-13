package com.easyblueapp.secureapp.util;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFutureUtil {
	
	public static int handleException2(Throwable throwable) {
		System.out.println("ERROR2: "+ throwable);
		return -1;
	}
	
	public static Void handleException(Throwable throwable) {
		System.out.println("ERROR: "+ throwable);
		throw new RuntimeException("it is beyond all hope");
	}
	
	public static CompletableFuture<Integer> create(int number){
		return CompletableFuture.supplyAsync(()-> number);
	}
	
	public static CompletableFuture<Integer> inc(int number){
		sleep(500);
		return CompletableFuture.supplyAsync(() -> number +1);
	}
	
	public static CompletableFuture<Integer> divide(int number, int i){
		return CompletableFuture.supplyAsync(() -> number /i);
	}
	
	public static CompletableFuture<Integer> incCompletableFuture(CompletableFuture<Integer> c){
		return c;
	}
	
	public static CompletableFuture<Integer> multiply(int number){
		return CompletableFuture.supplyAsync(() -> number *2);
	}
	
	public static void main(String[] args) {
		runTasks(2);
		runTasks(9);
		List<SendEmailTask> tasks = IntStream.range(0, 10)
				.mapToObj(e -> new SendEmailTask()).collect(Collectors.toList());
		useParallelStream(tasks);
	    useCompletableFutureWithExecutor(tasks);
	}
	
	 private static void runTasks(int i) {
		 System.out.println("In main "+ Thread.currentThread());
		 create(i)
			//.thenApply(data -> multiply(data))
			.thenCompose(data -> inc(data))
			.thenCompose(data -> multiply(data))
			.thenCompose(data -> inc(data))
			.thenCompose(data -> divide(data, i))
			.whenComplete((input, exception) ->{
				if (exception != null) {
	                System.out.println("exception occurs");
	                System.err.println(exception);
	            } else {
	                System.out.println("no exception, got result: " + input);
	            }
			})
//			.thenCompose(data -> inc(data))
			.exceptionally(throwable -> handleException2(throwable))
			.thenApply(input -> input * 3)
			.thenAccept(data -> System.out.println(data))
			.exceptionally(throwable -> handleException(throwable));
	 }
	 
	 private static boolean sleep(int ms) {
		 try {
			 Thread.sleep(ms);
			 return true;
		 }catch(InterruptedException e) {
			 return false;
		 }
	 }
	 
	 public static void useParallelStream(List<SendEmailTask> tasks) {
		 System.out.println("<<< Parallel stream processong >>>");
		 long start  = System.nanoTime();
		 List<String> result = tasks.parallelStream()
				 .map(SendEmailTask:: doUselessWork)
				 .collect(Collectors.toList());
		 long duration = (System.nanoTime() -start) / 1_000_000;
		 System.out.println("Processed "+ tasks.size() + " tasks in "+duration+ "ms");
		 System.out.println(result);
	 }
	 
	 public static void useCompletableFutureWithExecutor(List<SendEmailTask> tasks) {
		 System.out.println("\n <<<CompletableFuture parallel processing with custom executor >>>");
		 long start = System.nanoTime();
		 ExecutorService executor = Executors.newFixedThreadPool(Math.min(tasks.size(), 10));
		 List<CompletableFuture<String>> futures = 
				 tasks.parallelStream()
				 .map(t -> CompletableFuture.supplyAsync(() -> t.doUselessWork(), executor))
				 .collect(Collectors.toList());
		 
		 List<String> result = futures.stream()
				 	.map(CompletableFuture::join)
				 	.collect(Collectors.toList());
		 
		 long duration = (System.nanoTime() -start) /1_000_000;
		 System.out.println("Processed " + tasks.size() + " tasks in "+duration + "ms");
		 System.out.println(result);
		 executor.shutdown();
	}
}
