package com.FreshTastyBitesHouseWeb.springboot.FTBHW.controller;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.User;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.CartService;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.ProductService;

import jakarta.servlet.http.HttpSession;

@Controller
public class RecomendationController {
	
	@Autowired
	CartService cr;
	
    @Autowired
    ProductService ps;   
    
 // Mapping for the "/recomendation" endpoint, which handles GET requests
	
	@GetMapping("/recomendation") 
	public String getrecomendation(Model model,@RequestParam String category) {
		
		// Retrieve a list of products that match the specified category from the ProductService
	    // This method likely fetches products based on the selected category from the user's recent purchase or interaction
	
		model.addAttribute("productList",ps.pListByCategory(category));	
		// Example for each category (these would typically come from your data)
		
	    double x_A = 1; //  category A
	    double x_B = 2;  // category B
	    double x_C = 3; //  category C
	    double x_D = 4;  // category D
	    double w_A = 1;  // Weight for category A
	    double w_B = 2;  // Weight for category B
	    double w_C = 3;  // Weight for category C
	    double w_D = 4;  // Weight for category D
	    double weightedSum = (w_A * x_A) + (w_B * x_B) + (w_C * x_C) + (w_D * x_D);	
	    
// Perform mathematical operations to derive values based on user-selected categories
		
        double a = 5;                          // Example value for category 'A' (e.g. product in category A)
        double b = 3;                          // Example value for category 'B' (e.g.,product in category B)
        double result = a * b;                 // Example multiplication: This could represent a combining categories A and B
        model.addAttribute("result", result);  // Store the combined score for the view
       
                                                           // Addition: This might represent the total categories when both categories contribute positively
        double addition = a + b;                           // Adding the values from categories A and B
        model.addAttribute("additionResult", addition);    // Store total score in the model
        
       // Subtraction: This could represent the difference in preference between two categories
        double subtraction = a - b;                            // Finding the difference between category A and B
        model.addAttribute("subtractionResult", subtraction);   // Store the difference in the model
     
        // Multiplication: Similar to the earlier operation, it could be used to determine interaction effects
        double multiplication = a * b;                                // Reaffirming interaction effect between categories
        model.addAttribute("multiplicationResult", multiplication);   // Store interaction result in the model

        // Division: This could represent a ratio of preference or score between two categories
        
        double division = a / b;                            // Ratio of category A to category B
        model.addAttribute("divisionResult", division);     // Store the ratio in the model

        // Modulus: Could be used to determine cycles or repetitions in category selections
        
        double modulus = a % b;                             // Finding remainder to understand cycles in user preferences
        model.addAttribute("modulusResult", modulus);        // Store modulus result in the model

        // Increment: This might represent an increase in user preference for category A
        
        double increment = a++;                                // Incrementing category A's score or preference
        model.addAttribute("incrementResult", increment);      // Store incremented value in the model

        // Decrement: This might represent a decrease in user preference for category B
        
        double decrement = b--;                                // Decrementing category B's score or preference
        model.addAttribute("decrementResult", decrement);     // Store decremented value in the model
        
        
     // Store results in the model
        model.addAttribute("additionResult", addition);
        model.addAttribute("subtractionResult", subtraction);
        model.addAttribute("multiplicationResult", multiplication);
        model.addAttribute("divisionResult", division);
        model.addAttribute("modulusResult", modulus);
        model.addAttribute("incrementResult", increment);
        model.addAttribute("decrementResult", decrement);
								
	// Return the view page "RecommendationForm", which will display the list of recommended food products
		
		return "RecommendationForm";   
				
	}		
	
	@GetMapping("/getcanclehome")
	public String canclebuttonclickhome(@ModelAttribute User user,Model model,HttpSession session) {
		model.addAttribute("pList", ps.getAll()); 
		
		model.addAttribute("MList", ps.pListByCategory("MOMO")); 
		model.addAttribute("BList",ps.pListByCategory("BIRYANI")); 
		List<Object> KList= new ArrayList<>(); 
		model.addAttribute("KList", ps.pListByCategory("KATTI ROLL"));
		model.addAttribute("SList",ps.pListByCategory("SNACKS"));
		model.addAttribute("CWList",ps.pListByCategory("CHOWMEIN"));
		model.addAttribute("mwList",KList); 
		System.out.println(KList);
		  
		return"Customer_Home";
	}

}
