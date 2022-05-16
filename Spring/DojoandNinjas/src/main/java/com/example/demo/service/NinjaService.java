package com.example.demo.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Ninja;
import com.example.demo.repository.NinjaRepository;

@Service
public class NinjaService {
	private final NinjaRepository ninjarepository;

	public NinjaService(NinjaRepository ninjarepository) {
		this.ninjarepository = ninjarepository;
	}
	public List<Ninja> allninjas() {
        return ninjarepository.findAll();
    }
	
	public Ninja addninja(Ninja n) {
        return ninjarepository.save(n);
    }
}
