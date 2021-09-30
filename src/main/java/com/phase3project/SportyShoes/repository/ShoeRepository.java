package com.phase3project.SportyShoes.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.phase3project.SportyShoes.model.product_details;

@Repository
public interface ShoeRepository  extends CrudRepository<product_details, Integer>{

}

