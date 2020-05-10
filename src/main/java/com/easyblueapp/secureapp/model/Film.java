package com.easyblueapp.secureapp.model;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Film")
public class Film {
	
	@Id
	private String id;
	@NotEmpty
	private String title;
	private Integer year;
	@NotEmpty
	private String director;
	
	
	public Film(String title, Integer year, String director) {
		super();
		this.title = title;
		this.year = year;
		this.director = director;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	

}
