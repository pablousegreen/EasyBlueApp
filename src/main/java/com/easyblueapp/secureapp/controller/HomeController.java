package com.easyblueapp.secureapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.easyblueapp.secureapp.model.Employee;
import com.easyblueapp.secureapp.repository.EmployeeRepository;

@Controller
@RequestMapping("/easy")
public class HomeController {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	@GetMapping("/") 
	public String getBody(Model model, @RequestParam(defaultValue="0")int page) {		
		System.out.println("=>100A page: "+page);
		model.addAttribute("data", employeeRepository.findAll( PageRequest.of(page, 4, Sort.by("name").descending())));
		model.addAttribute("currentPage", page);
		return "newMovieBoots341";
	}
	
	@GetMapping("/getAll")
	@ResponseBody
	public ResponseEntity<?> getEmployees() {		
		return new ResponseEntity<>(this.employeeRepository.findAll(), HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/all")
    public List<Employee> getAll(){
        List<Employee> hotels = this.employeeRepository.findAll();

        return hotels;
    }

}
