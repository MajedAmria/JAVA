package com.example.demo.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.models.Book;
import com.example.demo.models.LoginUser;
import com.example.demo.models.User;
import com.example.demo.serviecs.BookService;
import com.example.demo.serviecs.UserService;


@Controller
public class HomeController {
    
    // Add once service is implemented:
    
     private UserService userServ;
     private BookService bookServ;
     
     
    
    public HomeController(UserService userServ, BookService bookServ) {
		this.userServ = userServ;
		this.bookServ = bookServ;
	}

	@GetMapping("/")
    public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new User());
        return "index.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser, 
            BindingResult result, Model model, HttpSession session) {
        
    
        User registerUser=userServ.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new User());
            return "index.jsp";
        }
     
        session.setAttribute("userId", registerUser.getId());
        return "redirect:/books";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
            BindingResult result, Model model, HttpSession session) {
        
        // Add once service is implemented:
         User user = userServ.login(newLogin, result);
    
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new User());
            return "index.jsp";
        }
    
  System.out.println();
        session.setAttribute("userId", user.getId());
        return "redirect:/books";
    }
    
    @GetMapping("/books")
    public String home(Model model,HttpSession session) {
    	if(session.getAttribute("userId")!=null) {
    		Long userId=(Long)session.getAttribute("userId");
    		User currenUser=userServ.findbyId(userId);
    		model.addAttribute("currentUser", currenUser);
    		List<Book> books=bookServ.allBooks();
			model.addAttribute("books",books);
    		return "books.jsp";
    	}

    	return "redirect:/";
    }
    
	@GetMapping("/new")
	 public String newbook(Model model,@ModelAttribute("book") Book book) {
		
		 return "new.jsp";
	 }
	

	@PostMapping("/new")
	public String createnew(@Valid @ModelAttribute("book") Book book,BindingResult result,HttpSession session) 
	{
		 if (result.hasErrors()) {
	            return "new.jsp";
		 }
		 else {
		Long userId=(Long)session.getAttribute("userId");
	    User currenUser=userServ.findbyId(userId);
	    book.setUser(currenUser);
		bookServ.createBook(book);
	    return "redirect:/books";
	}
}
    
	@GetMapping("/show/{id}")
	 public String show(Model model,@PathVariable("id") Long id,@ModelAttribute("book") Book book) {
		Book currbook=bookServ.findBook(id);
		model.addAttribute("currbook",currbook);
		 return "show.jsp";
	 }
	
	@GetMapping("/bookmarket")
	 public String bookmarket(Model model,HttpSession session) {
	    	if(session.getAttribute("userId")!=null) {
	    		Long userId=(Long)session.getAttribute("userId");
	    		User currenUser=userServ.findbyId(userId);
	    		model.addAttribute("currentUser", currenUser);
	    		List<Book> books=bookServ.findAll(null);
				model.addAttribute("notborrowbooks",books);
				List<Book> bo=bookServ.findAll(currenUser);
				model.addAttribute("toreturnbook",bo);
				return "bookmarket.jsp";
	    	}
	    	return "redirect:/";
	 }
	
	@GetMapping("/edit/{id}/update")
    public String edit(@PathVariable("id") Long id, Model model) {
		Book book = bookServ.findBook(id);
        model.addAttribute("book", book);
        return "edit.jsp";
    }
	 @PutMapping("/edit/{id}")
	    public String update(@Valid @ModelAttribute("book") Book book ,HttpSession session, BindingResult result) {
	        if (result.hasErrors()) {
	            return "edit.jsp";
	        } else {
	        	Long userId=(Long)session.getAttribute("userId");
	    		User currenUser=userServ.findbyId(userId);
	    		book.setUser(currenUser);
	        	bookServ.updatebook(book);
	            return "redirect:/books";
	        }
	    }
	 
	 @GetMapping("/delete/{id}")
	    public String destroy(@PathVariable("id") Long id) {
		 bookServ.deleteBook(id);
	        return "redirect:/bookmarket";
	    }
	 
	@GetMapping("/borrow/{id}")
	public String Borrow(@PathVariable("id") Long id,HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			Long userId=(Long)session.getAttribute("userId");
			Book thisbook=bookServ.findBook(id);
			Long user_Id=thisbook.getUser().getId();
    		User currenUser=userServ.findbyId(userId);
    		if(userId!=user_Id) {
    			thisbook.setBorrowedBy(currenUser);
    			bookServ.updatebook(thisbook);
    			return "redirct:/books";
    		}
			
		}
		return "redirct:/books";
	}
	
	@GetMapping("/return/{id}")
	public String Return(@PathVariable("id") Long id,HttpSession session) {
		if(session.getAttribute("userId")!=null) {
			Long userId=(Long)session.getAttribute("userId");
			Book thisbook=bookServ.findBook(id);
			Long user_Id=thisbook.getUser().getId();
//    		User currenUser=userServ.findbyId(userId);
    		if(userId!=user_Id) {
    			thisbook.setBorrowedBy(null);
    			bookServ.updatebook(thisbook);
    			return "redirct:/books";
    		}
    		return "redirct:/books";
		}
		return "redirct:/";
	}
	
    @GetMapping("/logout")
    public String logout(HttpSession session) {
    	session.invalidate();
    	return "redirect:/";
    }
    
}