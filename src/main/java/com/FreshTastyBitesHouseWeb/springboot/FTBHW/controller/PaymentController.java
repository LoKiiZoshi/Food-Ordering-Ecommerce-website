package com.FreshTastyBitesHouseWeb.springboot.FTBHW.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.KhaltiPaymentService;

@Controller
public class PaymentController { 
	
	@GetMapping("/sucess")
	public String getsucess() {
		return"sucess";
	}
	
	@GetMapping("/getForm")
	public String getpaymentform() {
		return "paymentFOrm";  
		
		
	}
 
    @Autowired
    private KhaltiPaymentService khaltiPaymentService;
  
    @PostMapping("/initiate-payment") 
    public RedirectView initiatePayment(
            @RequestParam int amount,
            @RequestParam String purchaseOrderId,
            @RequestParam String purchaseOrderName) {

        // Call the Khalti API service to get the payment URL
        String redirectUrl = khaltiPaymentService.initiatePayment("http://localhost:8080/","http://localhost:8080/sucess", amount, purchaseOrderId,
                purchaseOrderName);

        // Redirect to the payment URL if available
        if (redirectUrl != null) {
            return new RedirectView(redirectUrl); // Redirect user to the payment URL
        } else {
            // Handle error if payment URL is not available
            return new RedirectView("/error");
        }
    }
}
