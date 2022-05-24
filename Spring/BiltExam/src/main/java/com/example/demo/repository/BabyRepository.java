package com.example.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Baby;


@Repository
public interface BabyRepository extends CrudRepository<Baby, Long> {
	 List<Baby> findAll();
	 Optional<Baby> findById(Long id);
}
