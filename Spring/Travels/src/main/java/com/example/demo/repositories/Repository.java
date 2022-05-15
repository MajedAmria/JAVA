package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;


import com.example.demo.models.Expense;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<Expense, Long>{
	 List<Expense> findAll();
	 Optional<Expense> findById(Long id);
	 void deleteById(Long id);
}
