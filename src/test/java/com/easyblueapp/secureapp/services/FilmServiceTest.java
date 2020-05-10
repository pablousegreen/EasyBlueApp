package com.easyblueapp.secureapp.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.easyblueapp.secureapp.model.Employee;
import com.easyblueapp.secureapp.model.Film;
import com.easyblueapp.secureapp.repository.FilmRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
class FilmServiceTest {
	
	@Autowired
	private FilmService filmService;
	
	@Autowired
	FilmRepository filmRepository;
	
	private static final List<Film> DUMMY_FILMS = new ArrayList<Film>();
	
	/*@Test
	public void getFilms() throws InterruptedException, ExecutionException {

		filmRepository.deleteAll();
		DUMMY_FILMS.add(new Film("12 years a slave", 2013, "Steve McQueen"));
		DUMMY_FILMS.add(new Film("Argo", 2012, "Ben Affleck"));
		DUMMY_FILMS.add(new Film("The Artist", 2011, "Michel Hazanavicius"));
		DUMMY_FILMS.add(new Film("The King's speech", 2010, "Tom Hooper"));
		DUMMY_FILMS.add(new Film("The Hurt Locker", 2009, "Kathryn Bigelow"));
		DUMMY_FILMS.add(new Film("Slumdog Millionaire", 2008, "Danny Boyle"));
		DUMMY_FILMS.add(new Film("No Country for Old Men", 2007, "Joel y Ethan Coen"));
		filmRepository.saveAll(DUMMY_FILMS);
		//assertEquals(null, filmService);
//		List<Film> res = filmService.getFilms().get();
//		assertEquals(null, filmService.getFilms().get());
		//assertEquals(2, filmService.getFilms().get().size());
	}*/
	
	@Test
	public void create() throws InterruptedException, ExecutionException {
//		filmRepository.deleteAll();
//		DUMMY_FILMS.add(new Film("12 years a slave", 2013, "Steve McQueen"));
//		DUMMY_FILMS.add(new Film("Argo", 2012, "Ben Affleck"));
//		DUMMY_FILMS.add(new Film("The Artist", 2011, "Michel Hazanavicius"));
//		DUMMY_FILMS.add(new Film("The King's speech", 2010, "Tom Hooper"));
//		DUMMY_FILMS.add(new Film("The Hurt Locker", 2009, "Kathryn Bigelow"));
//		DUMMY_FILMS.add(new Film("Slumdog Millionaire", 2008, "Danny Boyle"));
//		DUMMY_FILMS.add(new Film("No Country for Old Men", 2007, "Joel y Ethan Coen"));
//		filmRepository.saveAll(DUMMY_FILMS);
		
		
		CompletableFuture<Integer> res = filmService.create().thenApplyAsync(a -> {
			return a;
		});
		assertEquals(2, res.get());
	}

}
