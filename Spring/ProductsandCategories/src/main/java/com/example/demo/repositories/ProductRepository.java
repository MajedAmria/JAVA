package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Category;
import com.example.demo.models.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
		
		List<Product> findAll();
	
	 	List<Product> findAllByCategories(Category category);
	    
	    List<Product> findByCategoriesNotContains(Category category);
	    
	    Optional<Product> findById(Long id);
}
