package com.example.demo.controllers;


import java.util.List;

import javax.validation.Valid;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.models.Category;
import com.example.demo.models.Product;
import com.example.demo.servces.CategoryServce;
import com.example.demo.servces.ProductServce;

@org.springframework.stereotype.Controller
public class Controller {
	
	@Autowired
	private CategoryServce catServce;
	private ProductServce proServce;
	
	
	public Controller(CategoryServce catServce, ProductServce proServce) {
		
		this.catServce = catServce;
		this.proServce = proServce;
	}

	@GetMapping("/")
	public String index(Model model) {
		List<Product> products = proServce.allProducts();
		List<Category> categories = catServce.allCategories();
		model.addAttribute("product",products);
		model.addAttribute("category",categories);
		return "home.jsp";
	}
	
	@GetMapping("/product/new")
	public String newproduct(@ModelAttribute("product") Product product) {
		
		return "newproduct.jsp";
	}
	
	@PostMapping("/product/new")
	public String createproduct(@Valid @ModelAttribute("product") Product product,BindingResult result) {
		 if (result.hasErrors()) {
	            return "newproduct.jsp";
	        } else {
	        	proServce.addProduct(product);
	    return "redirect:/";
	        }
	}
	
	@GetMapping("/category/new")
	public String newcategory(@ModelAttribute("category") Category category) {
		
		return "newcategory.jsp";
	}
	
	@PostMapping("/category/new")
	public String createcategory(@Valid @ModelAttribute("category") Category category,BindingResult result) {
		 if (result.hasErrors()) {
	            return "newcategory.jsp";
	        } else {
	        	catServce.addCategory(category);
	    return "redirect:/";
	        }
	}
	
	@GetMapping("/product/{id}")
	public String productpage(Model model,@PathVariable Long id) {
		
		List<Category> categories = catServce.findbyproducts(proServce.findbyId(id));
		List<Category> categorie=catServce.findbyProductsNotContan(proServce.findbyId(id));
		model.addAttribute("product",proServce.findbyId(id));
		model.addAttribute("category",categories);
		model.addAttribute("cat",categorie);
		return "productpage.jsp";
	}
	
	@PostMapping("/product/{id}")
	public String addProductToCategory(@PathVariable("id")Long product_id,@RequestParam("categories")Long category_id) {
		Product thisProduct=proServce.findbyId(product_id);
		Category thisCategory=catServce.findbyId(category_id);
		
		proServce.addCategoryToProduct(thisProduct,thisCategory);
		return "redirect:/product/"+product_id;
	}
	
	@GetMapping("/category/{id}")
	public String categorypage(Model model,@PathVariable Long id) {
		List<Product> products = proServce.findbycategories(catServce.findbyId(id));
		List<Product> product=proServce.findbyCategoriesNotContan(catServce.findbyId(id));
		model.addAttribute("category",catServce.findbyId(id));
		model.addAttribute("product",products);
		model.addAttribute("pro",product);
		return "categorypage.jsp";
	}
	
	@PostMapping("/category/{id}")
	public String addCategoryToPtoduct(@PathVariable("id")Long category_id,@RequestParam("products")Long product_id) {
		Product thisProduct=proServce.findbyId(product_id);
		Category thisCategory=catServce.findbyId(category_id);
		
		catServce.addProductsToCategory(thisCategory,thisProduct);
		return "redirect:/category/"+category_id;
	}
   
	
}
