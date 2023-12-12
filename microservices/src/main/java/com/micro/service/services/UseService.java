package com.micro.service.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.micro.service.feignsUser.Courses;
import com.micro.service.feignsUser.inscripciones;
import com.micro.service.models.Course;
import com.micro.service.models.Inscripciones;
import com.micro.service.models.User;
import com.micro.service.repository.UserRepository;

@Service
public class UseService {


	@Autowired
	private UserRepository useRepository;

	@Autowired
	private inscripciones insFeigns;
	
	@Autowired
	private Courses couFeigns;
	
	public Inscripciones saveIns(int userId,int courId) {
		Inscripciones ins = new Inscripciones();
		ins.setUserid(userId);
		ins.setCourseid(courId);
		Inscripciones nuIns = insFeigns.save(ins);
		return nuIns;
	} 
	
	public List<User> listUsers() {
		return useRepository.findAll();
	}
	
	public User create (User user) {
		return useRepository.save(user);
	}
	
	public Optional<User> findById(Long id){
		return useRepository.findById(id);
	}
	
	public Map<String,Object> getCourceUser(int userid){
		Map<String,Object> result = new HashMap<>();
		User user = useRepository.findById((long) userid).orElse(null);
		
		if(user ==null) {
			result.put("Mensaje"," El usuario no existe");
			return result;
		}
		
		result.put("Usuario", user);
		List<Inscripciones> ins = insFeigns.getIns(userid);
		if(ins.isEmpty()) {
			result.put("Cursos del  Usuario:", "En ningun Curso");
		}{
			result.put("Cursos del Usuario:",ins);
		}
		return result;
	}
	
	public Map<String,Object> getCour(int courseid){
		Map<String,Object> result = new HashMap<>();
		
		List<Inscripciones> ins = insFeigns.getCou(courseid);
		if(ins.isEmpty()) {
			result.put("Curso Integrantes", "Ningun estudiante");
		}{
			result.put("Curso Integrantes:",ins);
		}
		return result;
	}
	
	public Map<String,Optional> getCurso(int courseid){
		Map<String,Optional> result = new HashMap<>();
		Optional<Course> cour = couFeigns.getCour(courseid);
		if(cour.isEmpty()) {
			result.put("Cursos", null);
		}{
			result.put("Cursos:",cour);
		}
		return result;
	}
}
