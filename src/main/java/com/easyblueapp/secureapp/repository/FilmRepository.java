package com.easyblueapp.secureapp.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.easyblueapp.secureapp.model.Film;

public interface FilmRepository extends MongoRepository<Film, String>{

}
