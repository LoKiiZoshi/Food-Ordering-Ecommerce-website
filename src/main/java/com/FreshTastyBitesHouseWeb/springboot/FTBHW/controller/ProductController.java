package com.FreshTastyBitesHouseWeb.springboot.FTBHW.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Product;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.ProductService;


@Controller 
public class ProductController { 
	
	

    @Autowired
    private ProductService ps; 

    @GetMapping("/product") 
    public String getproduct() {
        return "AddProduct";  
    }
    @PostMapping("/AddProduct") 
   	public String postproduct(@ModelAttribute Product product, @RequestParam MultipartFile image) {

   		if (!image.isEmpty()) {

   			try {
   				Files.copy(image.getInputStream(),
   						Path.of("src/main/resources/static/img/" + image.getOriginalFilename()),
   						StandardCopyOption.REPLACE_EXISTING); 
   			} catch (IOException e) {
   				e.printStackTrace(); 
   			}
   		}

   		product.setImageUrl(image.getOriginalFilename());
   		System.out.println(image.getOriginalFilename()); 
   		ps.addproduct(product);
   		 
   		return "AddProduct";  
   	}
    
    
    
	
}
