package com.FreshTastyBitesHouseWeb.springboot.FTBHW.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.DeliveryAddress;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.CartService;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.DeliveryAddressService;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.ProductService;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.UserService;

@Controller  
public class OrderController {
	@Autowired
	ProductService ps; 
	@Autowired
	CartService cs;
	@Autowired 
	UserService us;
	@Autowired
	DeliveryAddressService das;
	@GetMapping("/order") 
	private String getOrder(Model model) {
		List<DeliveryAddress> aList= das.getAllAddress();
		model.addAttribute("aList",aList);
		return "Order"; 
	}

	
	@GetMapping("/orderDetails")                     
	private String getOrderDetails(Model model,@RequestParam int dId) {
		
		

		model.addAttribute("deliveryAddress", das.getAddressById(dId));
		System.out.println(das.getAddressById(dId));
		
		
		/* model.addAttribute("delvList",das.getAllAddress()); */

		return "OrderDetails";
	}
	
	
	

	@GetMapping("/deleteaddress/delete")  
	public String deleteproduct(Model model,@RequestParam int dId) {
		das.deleteById(dId);   
		return "redirect:/order";    
	}
	
}
