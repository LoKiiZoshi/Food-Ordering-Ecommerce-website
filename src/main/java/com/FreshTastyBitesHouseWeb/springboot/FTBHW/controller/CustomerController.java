package com.FreshTastyBitesHouseWeb.springboot.FTBHW.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.contants.CartStatus;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Cart;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Product;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.User;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.repository.CartRepository;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.repository.ProductRepository;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.CartService;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.ProductService;

import jakarta.servlet.http.HttpSession;


@Controller 
public class CustomerController {
	@Autowired
	CartService cs;
	@Autowired
	CartRepository cr;
	@Autowired
	private ProductService ps;

	@Autowired
	private ProductRepository pr;



	@PostMapping("/search")
	private String getSearch(Model model,@RequestParam String search) {
		System.out.println(search);
		System.out.println(search);
		System.out.println(search);
		System.out.println(search);
		System.out.println(search);
		System.out.println(search);

		List<Product> sList=pr.findAll(search);
		System.out.println(sList);
		System.out.println(sList);
		System.out.println(sList);
		System.out.println(sList);
		System.out.println(sList);
		System.out.println(sList);

		model.addAttribute("sList",sList);
		return "Search";
	}




	@GetMapping({"/cHome","/"}) 
	private String getCustomer(Model model , HttpSession session) {
		model.addAttribute("pList", ps.getAll()); 
		User u = (User) session.getAttribute("validuser");
		
		
		session.setAttribute("cList", cr.findByUserAndStatus(u, CartStatus.ACTIVE));



		List<Cart> c = cr.findByUserAndStatus(u, CartStatus.ACTIVE);
		session.setAttribute("size", c.size());   

		/* calculate total */
		
		double total=0; 
		for(Cart cart : c) {
			total=total+(cart.getSubTotal());
		}
		System.out.println(total);
		session.setAttribute("total",total);

		
			
		
		model.addAttribute("MList", ps.pListByCategory("MOMO")); 
		model.addAttribute("BList",ps.pListByCategory("BIRYANI")); 
		List<Object> KList= new ArrayList<>(); 
		model.addAttribute("KList", ps.pListByCategory("KATTI ROLL"));
		model.addAttribute("SList",ps.pListByCategory("SNACKS"));
		model.addAttribute("CWList",ps.pListByCategory("CHOWMEIN"));
		model.addAttribute("mwList",KList); 
		System.out.println(KList);
		  
		
		return "Customer_Home"; 
	}

	
	
	
	@GetMapping("/MOMO")
	private String getMOMO(Model model, HttpSession session) {
		model.addAttribute("MList", ps.pListByCategory("MOMO"));
		return "MOMO";  
	} 
	
	
	@GetMapping("/BIRYANI")
	private String getBIRYANI(Model model, HttpSession session) {
		model.addAttribute("BList",ps.pListByCategory("BIRYANI")); 
		return "BIRYANI";
	}
	
	@GetMapping("/KATTIROLL") 
	private String getKATTIROLL(Model model, HttpSession session) {
		model.addAttribute("KList", ps.pListByCategory("KATTI ROLL"));
		return "KATTI ROLL";
		
		//this work not complete-----
	}
	
	
	@GetMapping("/SNACKS")
	private String getSNACKS(Model model,HttpSession session) {
		model.addAttribute("SList",ps.pListByCategory("SNACKS"));
		return"SNACKS";
	}
	
	@GetMapping("/CHOWMEIN") 
	private String getCHOWMEIN(Model model,HttpSession session) {
		model.addAttribute("CWList",ps.pListByCategory("CHOWMEIN")); 
		return "CHOWMEIN";  
	} 
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/checkout")
	private String getCheckout(Model model, HttpSession session) {
		/*
		 * User u = (User) session.getAttribute("validuser"); List<Cart> c =
		 * cs.getByUser(u); model.addAttribute("cList", cs.getByUser(u));
		 * model.addAttribute("size", c.size());
		 */ 

		return"Checkout";
	}



}
