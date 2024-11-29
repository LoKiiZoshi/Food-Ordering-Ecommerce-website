package com.FreshTastyBitesHouseWeb.springboot.FTBHW.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.contants.CartStatus;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Cart;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.DeliveryAddress;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Product;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.User;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.repository.CartRepository;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.DeliveryAddressService;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.ShippingAddressService;
import jakarta.servlet.http.HttpSession;


@Controller
public class DeliveryController {
	
	
	@Autowired 
	private CartRepository cr;
	
	@Autowired
	DeliveryAddressService das;
	
	@Autowired
	ShippingAddressService sas;
	@PostMapping("/placeOrder")
	private String getPlaceOrder(@ModelAttribute DeliveryAddress deliveryAddress,HttpSession session,RedirectAttributes redirectattributes ) {
		User u = (User) session.getAttribute("validuser");
		deliveryAddress.setUser(u);
		deliveryAddress.setDate(Calendar.getInstance().getTime());
		
		List<Cart> cart= cr.findByUserAndStatus(u, CartStatus.ACTIVE);
        
	    
		
		/* calculate total for admin page */
		
			double total=0;
	        for(Cart cartt : cart) {
	        	total=total+(cartt.getSubTotal());
	        }
		deliveryAddress.setTotal(total); 
		
		/* for product list */
		
		List<Product> productlist= new ArrayList<>();
		
		for(Cart c:cart) {
			 productlist.add(c.getProduct());
		}	
		deliveryAddress.setProductsIdList(productlist);
		                   
		
		
		List<Integer> quantityList=new ArrayList<>();
		for(Cart c:cart) {
			 quantityList.add(c.getQuantity());
		}
		deliveryAddress.setQuantity(quantityList);
		 
		
		 
		
		
		// Add the user's delivery address to the billing address for future use
		das.addBillingAddress(deliveryAddress);
		
		// Update the cart status of the user to INACTIVE (likely marking the completion of the purchase)
		cr.updateCartStatusByUserId(u.getId(),CartStatus.INACTIVE);
		 
		
		
		// Fetch the first item from the user's cart (assumes cart is a list) 
		 Cart cr = cart.get(0); 
		 
		// Retrieve the product from the cart (this is the product the user added/ordered) 
		 Product pd = cr.getProduct();
		 
		// Get the category of the product that the user has selected or ordered
		 String usercategory =  pd.getCategory();
		 
		// Print the user category multiple times for debugging purposes (likely just to confirm it's being retrieved correctly)
		 System.out.println(usercategory);
		 System.out.println(usercategory);
		 System.out.println(usercategory);
		 System.out.println(usercategory);
		 System.out.println(usercategory);
		 System.out.println(usercategory);
		  
		 
		// Add the retrieved category to the redirect attributes to be passed along to the recommendation controller
		 redirectattributes.addAttribute("category",usercategory); 
		 
		 
		 
		// Redirect to the recommendation endpoint, where products based on the selected category will be displayed
		return "redirect:/recomendation";  
		
		
		/* return "redirect:/"; */ 
	}
	
	
	// Example method to calculate category weight based on category, cart size, and total price
	
    public double calculateCategoryWeight(String category, int cartSize, double total) {
        // Arbitrary weights based on category logic; you can modify this to use real logic
        double weight = 1.0;
        if (category.equalsIgnoreCase("Momo")) {
            weight = 1.5;
        } else if (category.equalsIgnoreCase("SNACKS")) {
            weight = 1.2;
        }
        // Example: multiply weight by cart size and total to influence final score
        return weight *(cartSize + total / 100); 
    }
	
	
	

	
}
