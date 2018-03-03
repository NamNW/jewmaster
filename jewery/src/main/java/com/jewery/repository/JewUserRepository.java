package com.jewery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jewery.entity.JewUser;

public interface JewUserRepository extends JpaRepository<JewUser, Long>{
	public JewUser findByUserName(String userName);
	
} 
