package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Dojo;
import com.example.demo.repository.DojoRepository;

@Service
public class DojoService {
	 private final DojoRepository dojorepository;

	public DojoService(DojoRepository dojorepository) {
		this.dojorepository = dojorepository;
	}

	public List<Dojo> alldojos() {
        return dojorepository.findAll();
    }
	public Dojo adddojo(Dojo d) {
        return dojorepository.save(d);
    }
}
