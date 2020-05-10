package com.easyblueapp.secureapp.util;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.easyblueapp.secureapp.model.Film;
import com.easyblueapp.secureapp.repository.FilmRepository;

class LambdasUtilTest {
	
	@Autowired
	FilmRepository filmRepository;
	
	private List<Film> res = null;

	@Test
	void test() throws InterruptedException, ExecutionException {
		//fail("Not yet implemented");
		CompletableFuture<List<Film>> completableFuture  
		  = CompletableFuture.supplyAsync(() -> {
			  setTimeout(() -> {
		        	System.out.println("test");
		        	res = this.filmRepository.findAll();
		        }, 10200);
		        System.out.println("-----CONTINUING-----");
			  return res;
		  });
		 
//		CompletableFuture<String> future = completableFuture
//		  .thenApplyAsync(s -> s + " World");
		 
		//assertEquals("Hello World", future.get());
		assertEquals("Hello World", completableFuture.get());
	}
	
	public void setTimeout(Runnable runnable, int delay){
	    new Thread(() -> {
	        try {
	            Thread.sleep(delay);
	            runnable.run();
	        }
	        catch (Exception e){
	            System.err.println(e);
	        }
	    }).start();
	}
	
	

}
