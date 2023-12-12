package com.inscripcion.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inscripcion.service.models.Inscripcion;

@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion,Integer>{

	List<Inscripcion> findByCourseid(int Courseid);	
	List<Inscripcion> findByUserid(int Userid);	
}
