package com.micro.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.micro.service.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{

}
