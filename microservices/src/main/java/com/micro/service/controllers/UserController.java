package com.micro.service.controllers;

import java.net.URI;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.micro.service.models.Inscripciones;
import com.micro.service.models.User;
import com.micro.service.services.UseService;

@RestController
@RequestMapping("/api/user/")
public class UserController {

	@Autowired
	public UseService useService;

	@PostMapping("/save")
	private ResponseEntity<User> save (@RequestBody User user){
		User temporal = useService.create(user);
		
		try {
			return ResponseEntity.created(new URI("/api/user/save"+temporal.getId())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	@GetMapping("/allList")
	private ResponseEntity<List<User>> allList (){
		return ResponseEntity.ok(useService.listUsers());
	}

	@GetMapping(value = "{id}")
	private ResponseEntity<Optional<User>> user (@PathVariable ("id") Long id){
		return ResponseEntity.ok(useService.findById(id));
	}
	
	@PostMapping("/inscripciones/{userid}/{courid}")
	public ResponseEntity<Inscripciones> saveIns(@PathVariable("userid") int userid,@PathVariable("courid") int courId){
		Inscripciones nueIns = useService.saveIns(userid, courId);
		return ResponseEntity.ok(nueIns);
	} 
	
	@GetMapping("/getCursos/{id}")
	public ResponseEntity<Map<String, Object>> listCursos(@PathVariable("id") int id){
		Map<String,Object> result = useService.getCourceUser(id);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getCourse/{id}")
	public ResponseEntity<Map<String, Object>> listCourse(@PathVariable("id") int id){
		Map<String,Object> result = useService.getCour(id);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/getCurso/{id}")
	public ResponseEntity<Map<String, Optional>> getCou(@PathVariable("id") int id){
		Map<String,Optional> result = useService.getCurso(id);
		return ResponseEntity.ok(result);
	}
	
}
