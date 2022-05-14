package com.example.demo.services;



import com.example.demo.models.Expense;
import com.example.demo.repositories.Repository;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
	 private final Repository repository;
	 
	 public Service(Repository repository) {
	        this.repository = repository;
	    }
	 
	 public List<Expense> allexpense() {
	        return repository.findAll();
	    }
	 
	 public Expense addexpense(Expense b) {
	        return repository.save(b);
	    }

}
