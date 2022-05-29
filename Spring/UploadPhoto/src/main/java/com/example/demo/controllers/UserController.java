package com.example.demo.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;




import com.example.demo.file.FileUploadUtil;
import com.example.demo.models.Product;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
    private UserRepository repo;

	@GetMapping("/users")
	public String index(Model model) {
		List<Product> products= repo.findAll();
	model.addAttribute("products", products);
		return "Photo.jsp";
	}
	
    @PostMapping("/users/save")
    public String saveUser(Product product,@RequestParam("image") MultipartFile multipartFile) throws IOException {
 
         
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        product.setPhotos(fileName);
         
        Product savedProduct = repo.save(product);
 
        String uploadDir = "user-photos/" + savedProduct.getId();
		 System.out.println("------->"+savedProduct.getPhotosImagePath());
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        
        return "redirect:/users";
    }
}