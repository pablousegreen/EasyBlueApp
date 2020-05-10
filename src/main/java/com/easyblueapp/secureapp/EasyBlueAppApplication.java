package com.easyblueapp.secureapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.easyblueapp.secureapp.model.Employee;
import com.easyblueapp.secureapp.model.Film;
import com.easyblueapp.secureapp.repository.EmployeeRepository;
import com.easyblueapp.secureapp.repository.FilmRepository;

@SpringBootApplication
public class EasyBlueAppApplication implements CommandLineRunner {
	
	@Autowired(required=true)
	EmployeeRepository repository;
	@Autowired(required=true)
	FilmRepository filmRepository;
	private static final List<Film> DUMMY_FILMS = new ArrayList<Film>();
	
	public static void main(String[] args) {
		
		SpringApplication.run(EasyBlueAppApplication.class, args);
	}
	
	@Override
	public void run (String ...run) throws Exception {
		repository.deleteAll();
		repository.save(new Employee("CONTABILITY", "ALEX G", 1023193));
		repository.save(new Employee("SYSTEMS", "RODOLFO R", 1023193));
		repository.save(new Employee("SALES", "ARTURO W", 1023193));
		repository.save(new Employee("MANAGEMENT", "RODRIGO G", 1023193));
		
		filmRepository.deleteAll();
		DUMMY_FILMS.add(new Film("12 years a slave", 2013, "Steve McQueen"));
		DUMMY_FILMS.add(new Film("Argo", 2012, "Ben Affleck"));
		DUMMY_FILMS.add(new Film("The Artist", 2011, "Michel Hazanavicius"));
		DUMMY_FILMS.add(new Film("The King's speech", 2010, "Tom Hooper"));
		DUMMY_FILMS.add(new Film("The Hurt Locker", 2009, "Kathryn Bigelow"));
		DUMMY_FILMS.add(new Film("Slumdog Millionaire", 2008, "Danny Boyle"));
		DUMMY_FILMS.add(new Film("No Country for Old Men", 2007, "Joel y Ethan Coen"));
		filmRepository.saveAll(DUMMY_FILMS);
	}

}
