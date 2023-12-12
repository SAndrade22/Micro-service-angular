package com.course.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.service.models.Cource;

@Repository
public interface CourceRepository extends JpaRepository<Cource,Long>{

}
