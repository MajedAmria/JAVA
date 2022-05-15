package com.example.demo.reposetory;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Language;

@org.springframework.stereotype.Repository
public interface Repository extends CrudRepository<Language, Long> {
	
	List<Language> findAll();
	 Optional<Language> findById(Long id);
	 void deleteById(Long id);
}
