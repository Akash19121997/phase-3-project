package com.phase3project.SportyShoes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phase3project.SportyShoes.model.user;


	@Repository
public interface UserRepository  extends CrudRepository<user, Integer>{
		
	}
