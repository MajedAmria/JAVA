package com.example.demo.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Project;
import com.example.demo.model.User;
@Repository
public interface ProjectRepository extends CrudRepository<Project, Long> {
	List<Project> findAll();
	List<Project> findAllById(Long id);

    List<Project> findAllByUsers(User user);
    List<Project> findByUsersByNotContains(User user);

    void deleteById(Long id);
}
