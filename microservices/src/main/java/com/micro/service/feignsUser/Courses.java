package com.micro.service.feignsUser;


import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.micro.service.models.Course;

@FeignClient(name = "course-service",url="http://localhost:8002")
public interface Courses {
	
	@GetMapping("/api/cource/curso/{id}")
	public Optional<Course> getCour(@PathVariable ("id") Integer id);
}
