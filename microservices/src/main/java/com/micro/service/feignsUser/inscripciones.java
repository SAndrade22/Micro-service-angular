package com.micro.service.feignsUser;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.micro.service.models.Inscripciones;

@FeignClient(name = "inscripciones-service",url = "http://localhost:8003") 
public interface inscripciones {
	

	@PostMapping("/api/inscripcion/save")
	public Inscripciones save(@RequestBody Inscripciones  inscr);
	
	@GetMapping("/api/inscripcion/user/{id}")
	public List<Inscripciones> getIns(@PathVariable ("id") Integer id);
	
	@GetMapping("/api/inscripcion/course/{id}")
	public List<Inscripciones> getCou(@PathVariable ("id") Integer id);
	
}
