package com.example.demo.servces;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.repositories.ProductRepository;

@Service
public class ProductServce {
	
	ProductRepository productrepo;
	
	public ProductServce(ProductRepository productrepo) {
		this.productrepo = productrepo;
	}

	
	public List<Product> allProducts(){
		return productrepo.findAll();
	}
	
	public Product addProduct(Product p) {
		return productrepo.save(p);
	}
	public Product findbyId(Long id) {
		return productrepo.findById(id).get();
	}
	
	public List<Product> findbycategories(Category category){
		return productrepo.findAllByCategories(category);
	}
    

}
