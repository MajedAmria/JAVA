package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Product;


public interface UserRepository extends CrudRepository<Product, Long> {
     
	Optional<Product> findById(Long id);
	List<Product> findAll();
	List<Product> findByPhotos(String photos);
	
}
