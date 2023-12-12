package com.course.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.service.models.Cource;
import com.course.service.repository.CourceRepository;

@Service
public class CourceService {

	@Autowired
	private CourceRepository couRepository;
	
	public List<Cource> listCource(){
		return couRepository.findAll();
	}
	
	public Cource create (Cource cource) {
		return couRepository.save(cource);
	}
	
	public Optional<Cource> findById(Long id){
		return couRepository.findById(id);
	}
	
}
