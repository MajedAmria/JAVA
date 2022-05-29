package com.example.demo.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;



import com.example.demo.file.FileUploadUtil;
import com.example.demo.models.User;
import com.example.demo.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
    private UserRepository repo;

	@GetMapping("/users")
	public String index(User user,Model model) {
		model.addAttribute("showPhoto", user.getPhotos());
		System.out.println(user);
		return "Photo.jsp";
	}
	
    @PostMapping("/users/save")
    public String saveUser(User user,
            @RequestParam("image") MultipartFile multipartFile) throws IOException {
         
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        user.setPhotos(fileName);
         
        User savedUser = repo.save(user);
 
        String uploadDir = "user-photos" + savedUser.getId();
 
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        
        return "redirect:/users";
    }
}