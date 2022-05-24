package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Baby;
import com.example.demo.model.User;
import com.example.demo.repository.BabyRepository;

@Service
public class BabyService {
	
    @Autowired
	private BabyRepository babyRepo;
	 
	public List<Baby> allBabies(){
		return babyRepo.findAll();
		
	}
	
	public Baby create(Baby baby) {
		return babyRepo.save(baby);	
	}
	public Baby updateBabyName(Baby baby) {
		return babyRepo.save(baby);	
	}
	
	public Baby findbyId(Long id) {
		   return babyRepo.findById(id).orElse(null);  
	   }
	   public void deleteBaby(Long id) {
	        
		   babyRepo.deleteById(id);
	    }
}
