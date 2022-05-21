package com.example.demo.serviecs;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.example.demo.models.LoginUser;
import com.example.demo.models.User;
import com.example.demo.reposetories.UserRepository;


    

    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    public User register(User newUser, BindingResult result) {
        Optional<User> isUser=userRepo.findByEmail(newUser.getEmail());
        if(isUser.isPresent()) {
        result.rejectValue("email", "Matches", "Email alreedy exist");	
        }
        if(!newUser.getPassword().equals(newUser.getConfirm())) {
            result.rejectValue("confirm", "Matches", "The confirm password must match");	
            }
        String toCheck=newUser.getUserName();
        if(!toCheck.matches(("[a-zA-Z]+"))) {
        	result.rejectValue("userName", "Matches", "Must contain letter only");
        }
        if(result.hasErrors()) {
        	return null;
        }
        else {
        	String hashed=BCrypt.hashpw(newUser.getPassword(),BCrypt.gensalt());
        	newUser.setPassword(hashed);
        	userRepo.save(newUser);
        	return newUser;
        }
    }
    public User login(LoginUser newLoginObject, BindingResult result) {
    	if(result.hasErrors()) {
    		return null;
    	}
    	 Optional<User> isUser=userRepo.findByEmail(newLoginObject.getEmail());
    	if(!isUser.isPresent()) {
            result.rejectValue("email", "Matches", "Unknown email");	
            return null;
            }
    	User user=isUser.get();
    	if(!BCrypt.checkpw(newLoginObject.getPassword(), user.getPassword())) {
    		result.rejectValue("password", "Matches", "Invalid Password!");
    	}
    	if(result.hasErrors()) {
    		return null;
    	}
    	else {
        return user;
    }
    	}
    
   public User findbyId(Long id) {
	   return userRepo.findById(id).orElse(null);  
   }
   
  
   
   
}