package com.FreshTastyBitesHouseWeb.springboot.FTBHW.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.User;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.UserService;

import jakarta.servlet.http.HttpSession;



@Controller
public class AdminController {
	
	
	
	

    @Autowired
	 private UserService us ;
	
	 @GetMapping("/AdminLogin")
	 public String getLogin() {
		 return "AdminLoginForm";   
	} 
	 
	 
	 
	 @GetMapping("/DasboardHome")  
	 public String getDasboarHome() {
	 return "DashboardForm"; 
	 }
	
	
	 /*Handles POST request for Admix login, authenticates user, and redirects to appropriate view based on role. */
	
	

	 @PostMapping("/adminlogin") 
	 public ModelAndView adminLogin(@ModelAttribute User user, Model model, HttpSession session) {
	     User authenticatedUser = null;

	     try { 
	         authenticatedUser = us.authenticate(user.getUsername(), user.getPassword());
	     } catch (Exception e) {
	         e.printStackTrace();
	         ModelAndView errorView = new ModelAndView("AdminLoginForm");
	         errorView.addObject("msg", "An error occurred during login. Please try again.");
	         return errorView;
	     }

	     if (authenticatedUser != null && "ROLE_ADMIN".equals(authenticatedUser.getRole())) {
				session.setAttribute("validuser", authenticatedUser);   /* Set the user in the session */ 
	         ModelAndView successView = new ModelAndView("DashboardForm");
	         successView.addObject("admin", authenticatedUser);
	         return successView;
	     } else {
	         ModelAndView failureView = new ModelAndView("AdminLoginForm");
	         failureView.addObject("msg", "Please enter correct username and password");
	         return failureView; 
	     }
	 }
}


