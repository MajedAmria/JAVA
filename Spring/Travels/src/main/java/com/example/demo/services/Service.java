package com.example.demo.services;



import com.example.demo.models.Expense;
import com.example.demo.repositories.Repository;

import java.util.Optional;

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
	 public Expense findexpense(Long id) {
	       Optional<Expense> optional = repository.findById(id);
	        if(optional.isPresent()) {
	            return optional.get();
	        } else {
	            return null;
	        }
	    }
	 
	 public Expense updateexpense(Expense expense) {
//		 	repository.findById(expense.getId());
	    	return repository.save(expense);
	    	
	    	
	    }
	 
	 public void deleteBook(Long id) {
		 repository.deleteById(id);
	 }
	 

}
