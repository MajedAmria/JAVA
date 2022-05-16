package com.example.demo.repository;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.demo.model.Dojo;

@Repository
public interface DojoRepository extends CrudRepository<Dojo, Long> {
	
	List<Dojo> findAll();

}
