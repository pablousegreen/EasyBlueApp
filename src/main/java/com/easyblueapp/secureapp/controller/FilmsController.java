package com.easyblueapp.secureapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.easyblueapp.secureapp.model.Film;
import com.easyblueapp.secureapp.repository.FilmRepository;

@RestController
@RequestMapping(value = "/films")
public class FilmsController {
	
	@Autowired
	FilmRepository filmRepository;
	
	private List<Film> res = null;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<?> getFilms(HttpServletRequest request) {
		String contextPath = request.getContextPath();
        System.out.println(contextPath);
        setTimeout(() -> {
        	System.out.println("test");
        	res = this.filmRepository.findAll();
        }, 100200);
        System.out.println("-----CONTINUING-----");
        request.setAttribute("path", contextPath);
		return new ResponseEntity<>(this.filmRepository.findAll(), HttpStatus.ACCEPTED);
        //return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public void addFilm(@RequestBody @Valid Film film) {
		this.filmRepository.save(film);
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
