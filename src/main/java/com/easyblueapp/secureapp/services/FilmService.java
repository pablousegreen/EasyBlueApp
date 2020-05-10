package com.easyblueapp.secureapp.services;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.easyblueapp.secureapp.model.Film;
import com.easyblueapp.secureapp.repository.FilmRepository;


@Service
public class FilmService {
	
	@Autowired
	FilmRepository filmRepository;
	
	private List<Film> res = null;
	
	public int compute() {
		 setTimeout(() -> {
        	System.out.println("test");
//        	res = this.filmRepository.findAll();
//        	res.stream().forEach(f -> {
//        		System.out.println(f.getId() + " -  "+f.getDirector());
//        	});
        	
        }, 10200);
		return 2;
	}
	
//	public CompletableFuture<List<Film>> create() {
	public CompletableFuture<Integer> create() {
		
			return CompletableFuture.supplyAsync(() -> compute());
		
	
		
		/*setTimeout(() -> {
			        	System.out.println("test");
			        	res = this.filmRepository.findAll();
			        	res.stream().forEach(f -> {
			        		System.out.println(f.getId() + " -  "+f.getDirector());
			        	});
			        	
			        }, 10200);*/
	
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
