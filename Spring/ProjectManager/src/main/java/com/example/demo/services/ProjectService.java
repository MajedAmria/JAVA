package com.example.demo.services;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Project;
import com.example.demo.model.User;
import com.example.demo.repository.ProjectRepository;



@Service
public class ProjectService {
 
	@Autowired
	private ProjectRepository prorepository;
	
	
	public Project creatproject(Project p) {
		return prorepository.save(p);
	}
    // returns all the books
    public List<Project> allProjectss() {
        return prorepository.findAll();
    }
    
    // retrieves a book
    public Project findProject(Long id) {
        Optional<Project> optionalBook = prorepository.findById(id);
        if(optionalBook.isPresent()) {
            return optionalBook.get();
        } else {
            return null;
        }
}
    

	 public Project updateProject(Project project) {

	    	return prorepository.save(project);
	    	
	    	
	    }
    
//    public List<Project> findAll(User user) {
//    	List<Project> listborrow=prorepository.findAllByBorrowedBy(user);
//    	return listborrow ;
//    
//    }
    public void deleteProject(Long id) {
        
    	prorepository.deleteById(id);
    }



	
}
