package com.phase3project.SportyShoes.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.SQLQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.phase3project.SportyShoes.model.product_details;
import com.phase3project.SportyShoes.model.purchase_details;
import com.phase3project.SportyShoes.model.user;
import com.phase3project.SportyShoes.repository.AdminRepository;
import com.phase3project.SportyShoes.repository.PurchaseRepository;
import com.phase3project.SportyShoes.repository.ShoeRepository;
import com.phase3project.SportyShoes.repository.UserRepository;

@Service
public class ShoeService {
	
	@Autowired
	ShoeRepository shoeRepository;
	@Autowired
	PurchaseRepository purchaseRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	AdminRepository adminRepository;
	
	public List<product_details> getAllProductDetails(){
		List<product_details> product= new ArrayList();
		shoeRepository.findAll().forEach(product_details -> product.add(product_details));
		return product;
	}
	public List<purchase_details> getAllPurchaseDetails(){
		List<purchase_details> detail=new ArrayList();
		purchaseRepository.findAll().forEach(purchase_details -> detail.add(purchase_details));
		return detail;
	}
	public List<user> getAllUser(){
		List<user> detail=new ArrayList();
		userRepository.findAll().forEach(user -> detail.add(user));
		return detail;
	}
	
}
