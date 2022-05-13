package com.lyk.jwt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lyk.jwt.model.User;

public interface UserRepository extends JpaRepository<User, Long>{
	User findByUsername(String username);
}
