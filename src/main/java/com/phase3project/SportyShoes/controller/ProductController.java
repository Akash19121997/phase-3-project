package com.phase3project.SportyShoes.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.phase3project.SportyShoes.model.admin;
import com.phase3project.SportyShoes.model.product_details;
import com.phase3project.SportyShoes.model.purchase_details;
import com.phase3project.SportyShoes.model.user;
import com.phase3project.SportyShoes.repository.AdminRepository;
import com.phase3project.SportyShoes.service.ShoeService;


@Controller
public class ProductController {
	
	@Autowired
	ShoeService shoeService;
	@Autowired
	private AdminRepository ar;
	
	@GetMapping("/productDetails")
	public String getAllProducts(Model model){
		List<product_details> products=shoeService.getAllProductDetails();
		model.addAttribute("products",products);
		return "listProducts";
	}
	@GetMapping("/purchaseDetails")
	public String getAllPurchase(Model model){
		List<purchase_details> purchase=shoeService.getAllPurchaseDetails();
		model.addAttribute("purchase",purchase);
		return "listPurchase";
	}
	/*@GetMapping("/userDetails")
	public List<user> getAllUser(){
		return shoeService.getAllUser();
	}*/
	/*
	 * @GetMapping("/greet") public String greet() { return "index"; }
	 */
	@GetMapping("/userDetails")
	public String listUser(Model model) {
		
		List<user> users = shoeService.getAllUser();
		model.addAttribute("users", users);
		return "listUsers";
	}
	@GetMapping({"/admin-login","/"})
	public String loginAdmin(Model model) {
	admin ob =new admin();
	model.addAttribute("object", ob);
	return "loginpage";
	}
	@PostMapping("/validate-user")
	public String ValidateUser(@ModelAttribute("object") admin ad,Model model) {
		Optional<admin> findById = ar.findById(1);
		if(findById.get().getEmail().equals(ad.getEmail())&& findById.get().getPassword().equals(ad.getPassword())) {
			
			return "index";
		}
		else {
			String error= "Invalid Credentials !!! \n Enter valid details.";
			model.addAttribute("errmsg",error);
			return "loginpage";
		}
	}
	@GetMapping("/editPassword")
	public String editPassword(Model model) {
		admin ob=new admin();
		model.addAttribute("object",ob);
		return "editpassword";
	}
	@PostMapping("/save-password")
	public String savePassword(@ModelAttribute("object")admin ad,Model model) {
		Optional<admin> findById = ar.findById(1);
		findById.get().setPassword(ad.getPassword());
		ar.save(findById.get());
		return "index";
	}
}
