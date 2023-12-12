package com.inscripcion.service.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inscripcion.service.models.Inscripcion;
import com.inscripcion.service.repository.InscripcionRepository;

@Service
public class InscripcionService {

	@Autowired
	private InscripcionRepository insRepository;
	
	public List<Inscripcion> listCource(){
		return insRepository.findAll();
	}
	
	public Inscripcion create (Inscripcion ins) {
		return insRepository.save(ins);
	}
	
	public Optional<Inscripcion> findById(int id){
		return insRepository.findById(id);
	}
	
	public List<Inscripcion> byCourseId(int Courseid){
		return insRepository.findByCourseid(Courseid);
	}
	
	public List<Inscripcion> byUserId(int Userid){
		return insRepository.findByUserid(Userid);
	}

}
