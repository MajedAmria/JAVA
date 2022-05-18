package com.example.demo.servces;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.CategoryRepository;

@Service
public class CategoryServce {
	
	@Autowired
	CategoryRepository categoryrepo;
	
	public List<Category> allCategories() {
        return categoryrepo.findAll();
    }
	
	public List<Category> findbyproducts(Product product){
		return categoryrepo.findAllByProducts(product);
	}
	
	public Category addCategory(Category c) {
        return categoryrepo.save(c);
    }
	
	public Category findbyId(Long id) {
		return categoryrepo.findById(id).get();
	}
	
	public Category updatecategory(Category c){
//		categoryrepo.findById(c.getId());
		return categoryrepo.save(c);
	}
}
