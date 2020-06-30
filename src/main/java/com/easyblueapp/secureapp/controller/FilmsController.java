package com.easyblueapp.secureapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@GetMapping
	public ResponseEntity<?> getFilms(HttpServletRequest request) {
		
        System.out.println("-----CONTINUING-----");
        return new ResponseEntity<>(this.filmRepository.findAll(), HttpStatus.ACCEPTED);
        //return new ResponseEntity<>(res, HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	public void addFilm(@RequestBody @Valid Film film) {
		this.filmRepository.save(film);
	}

}
