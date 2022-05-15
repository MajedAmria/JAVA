package com.example.demo.servecs;

import com.example.demo.model.Language;
import com.example.demo.reposetory.Repository;

import java.util.Optional;

import java.util.List;

@org.springframework.stereotype.Service
public class Service {
	 private final Repository repository;

	public Service(Repository repository) {
		this.repository = repository;
	}
	 
	  public List<Language> allLanguage() {
	        return repository.findAll();
	    }
	  
	  public Language addLanguage(Language l) {
	        return repository.save(l);
	    }
	 
	 public Language findLanguage(Long id) {
	       Optional<Language> optional = repository.findById(id);
	        if(optional.isPresent()) {
	            return optional.get();
	        } else {
	            return null;
	        }
	    }
	 
	 public Language updateLanguage(Language lan) {

	    	return repository.save(lan);
	    	
	    	
	    }
	 
	 public void deleteLanguage(Long id) {
		 repository.deleteById(id);
	 }
	 
}
