package com.phase3project.SportyShoes.repository;

import org.springframework.data.repository.CrudRepository;

import com.phase3project.SportyShoes.model.purchase_details;

public interface PurchaseRepository extends CrudRepository<purchase_details, Integer> {

}
