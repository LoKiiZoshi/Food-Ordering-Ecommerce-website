package com.FreshTastyBitesHouseWeb.springboot.FTBHW.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.contants.CartStatus;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Cart;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.User;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.repository.CartRepository;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.CartService;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.ProductService;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.UserService;


import jakarta.servlet.http.HttpSession;

 

@Controller
public class UserController {
	
	@Autowired
	ProductService ps;
	
	@Autowired
	UserService us;
	
	@Autowired
	CartService cs;
    
	@Autowired
	CartRepository cr;
	

	@GetMapping("/login") 
	public String getLogin() { 

		return "LoginForm"; 

	}
	@GetMapping("/Signup")
	public String getsignup() {
		return "SignUpForm"; 
	}
 

	  @PostMapping("/newuserregister")
	    public ModelAndView newUserRegister(@ModelAttribute User user) {
		  
		  
       /* Check if user name already exists in the database */
		 
	         boolean exists = this.us.checkUserExists(user.getUsername());

	        
	        if (!exists) {
	            System.out.println("Username: " + user.getUsername());
	            user.setRole("ROLE_NORMAL");
	            this.us.signup(user);
	            System.out.println("New user created with password: " + user.getPassword());
	            ModelAndView successView = new ModelAndView("LoginForm");
	            return successView;
	        } else {
	            System.out.println("New user not created - username taken: " + user.getUsername());
	            ModelAndView failureView = new ModelAndView("SignupForm");
	            failureView.addObject("msg", user.getUsername() + " is taken. Please choose a different username.");
	            return failureView;
	            
	            
	        }
	    }
	

	  
	  

    /* Handles POST request for user login. */ 
	  
	@PostMapping("/login")  
	public String postLogin(@ModelAttribute User user,Model model,HttpSession session) { 
		
		
		
		User u = us.loginUser(user.getUsername(), user.getPassword());
		if(u != null) {
			
			session.setAttribute("validuser", u);
			
			
			/* If login successful, display product list on index page */
			
			model.addAttribute("pList", ps.getAll());
			
			
			session.setAttribute("cList", cr.findByUserAndStatus(u, CartStatus.ACTIVE));
			List<Cart> c = cr.findByUserAndStatus(u, CartStatus.ACTIVE);
			session.setAttribute("size", c.size());  
			
			
			
			model.addAttribute("MList", ps.pListByCategory("MOMO")); 
			model.addAttribute("BList",ps.pListByCategory("BIRYANI")); 
			List<Object> KList= new ArrayList<>(); 
			model.addAttribute("KList", ps.pListByCategory("KATTI ROLL"));
			model.addAttribute("SList",ps.pListByCategory("SNACKS"));
			model.addAttribute("CWList",ps.pListByCategory("CHOWMEIN"));
			model.addAttribute("mwList",KList); 
			
			
			
			
			 
			
			
			
			return "Customer_Home"; 
		
		}else {
			model.addAttribute("error","user not found!!");
			return "LoginForm";
		}  
	} 
	
	
	

	@GetMapping("/logout")
	private String logout(HttpSession session) {

		session.invalidate();  
		return "AdminLoginForm";  
	}

	@GetMapping("/profile")
	public String getProfile() {
		return "Profile";
		
	}

	
	
	
	
}
