package com.example.demo.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.models.Category;
import com.example.demo.models.Product;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
	
		List<Category> findAll();
	  
	    List<Category> findAllByProducts(Product product);
	    
	    List<Category> findByProductsNotContains(Product product);
	    
	    Optional<Category> findById(Long id);
}
