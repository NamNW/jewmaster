package com.jewery.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jewery.entity.JewUserProfile;

public interface JewUserProfileRepository  extends JpaRepository<JewUserProfile, Long>{
	
}
