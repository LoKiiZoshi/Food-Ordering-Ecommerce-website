package com.FreshTastyBitesHouseWeb.springboot.FTBHW.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.repository.ProductRepository;

import jakarta.servlet.http.HttpSession;

@Controller
public class GalleryController {
	@Autowired
	private ProductRepository pr;
	@GetMapping("/gallery")
public String getGallery(Model model,HttpSession session) {
		
		if(session.getAttribute("validuser")==null) {
			return"LoginForm";
		}
		else {
		String[]imgNames= new File("src/main/resources/static/images").list();
		model.addAttribute("imgNameList",imgNames);
	return"GalleryForm";
		}
}
	@GetMapping("/productGallery")
public String getProductGallery(Model model,HttpSession session) {
		
		if(session.getAttribute("validuser")==null) {
			return"LoginForm";
		}
		else {
			model.addAttribute("pList",pr.findAll());
	return"ProductGalleryForm";
		}
}
	
	
}
