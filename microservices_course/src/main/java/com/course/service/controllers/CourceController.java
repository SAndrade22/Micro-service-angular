package com.course.service.controllers;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.course.service.models.Cource;
import com.course.service.services.CourceService;

@RestController
@RequestMapping("api/cource/")
@CrossOrigin(origins = "http://localhost:4200")
public class CourceController {
	
	@Autowired
	public CourceService couService;
	
	@PostMapping("/save")
	private ResponseEntity<Cource> save (@RequestBody Cource cou){
		Cource temporal = couService.create(cou);
		
		try {
			return ResponseEntity.created(new URI("/api/cource/save"+temporal.getId())).body(temporal);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
	}
	
	
	@GetMapping("/allList")
	private ResponseEntity<List<Cource>> allList (){
		return ResponseEntity.ok(couService.listCource());
	}

	@GetMapping("curso/{id}")
	private ResponseEntity<Optional<Cource>> user (@PathVariable ("id") Long id){
		return ResponseEntity.ok(couService.findById(id));
	}
}
