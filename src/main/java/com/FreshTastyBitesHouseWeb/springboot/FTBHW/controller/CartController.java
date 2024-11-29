package com.FreshTastyBitesHouseWeb.springboot.FTBHW.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import org.springframework.web.bind.annotation.RequestParam;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.contants.CartStatus;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Cart;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Product;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.User;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.repository.CartRepository;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.CartService;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.ProductService;

import jakarta.servlet.http.HttpSession;
@Controller
public class CartController {
	@Autowired
	private ProductService  ps;

	@Autowired 
	private CartService cs;
	
	@Autowired
	private CartRepository cr;

	@GetMapping("/addToCart")
	private String addToCart(@RequestParam int id, HttpSession  session, Model model) {
		
		if(session.getAttribute("validuser")==null) {
			return "LoginForm";
			
		} 

	else {  
		System.out.println(session.getAttribute("validuser"));

		User  u = (User) session.getAttribute("validuser");

		System.out.println("-------user name = "+u.getFirstName());

		
		Product p = ps.getById(id);
		double price = p.getPrice();
		
		
		Cart cart= new Cart();
		cart.setProduct(ps.getById(id));
		cart.setUser(u);
		cart.setStatus(CartStatus.ACTIVE);
		cart.setQuantity(1);
		cart.setSubTotal(price*cart.getQuantity());

		cs.addCart(cart);

		/*
		 * model.addAttribute("pList", ps.getAll()); List<Cart> c = cs.getAllCart();
		 * 
		 * model.addAttribute("size", c.size()); model.addAttribute("cList",
		 * cs.getAllCart());
		 */ 
		return "redirect:/cHome";
	}
	}
	@GetMapping("/cart")
	private String getCart( Model model, HttpSession session) {
		User u = (User) session.getAttribute("validuser");
		session.setAttribute("cList", cr.findByUserAndStatus(u,CartStatus.ACTIVE));
		List<Cart> c = cr.findByUserAndStatus(u,CartStatus.ACTIVE);
		session.setAttribute("size", c.size());  
		
		/* calculate total */ 
		
			double total=0;
	        for(Cart cart : c) {
	        	total=total+(cart.getSubTotal());
	        }
	        System.out.println(total);
		session.setAttribute("total",total);
		
						
		/*
		 * User u =(User) session.getAttribute("validuser"); System.out.println(u);
		 * System.out.println("-------user name = "+u.getFirstName());
		 * 
		 * System.out.println(cs.getByUser(u)); System.out.println(u.getId());
		 * model.addAttribute("cList", cs.getByUser(u)); List<Cart> c = cs.getByUser(u);
		 * double total=0; for(Cart cart : c) { total=total+(cart.product.price); }
		 * System.out.println(total); model.addAttribute("total",total);
		 * model.addAttribute("size", c.size());
		 */
		return "Cart";
	}

	@GetMapping("/removeCartFromDropdown")
	private String removeCartFromDropdown(Model model, @RequestParam int id) {
		cs.deleteById(id);
		
		/*
		 * model.addAttribute("pList", ps.getAll()); List<Cart> c = cs.getAllCart();
		 * model.addAttribute("cList", cs.getAllCart()); model.addAttribute("size",
		 * c.size());
		 */
		
		return "redirect:/cHome";
	}
	@GetMapping("/removeCartFromCart")
	private String removeCartFromCart(Model model, @RequestParam int id) {
		cs.deleteById(id);

		return "redirect:/cart";
	}
	
	
	
	@GetMapping("/increaseQuantity")
	private String increaseQuantity(@RequestParam int id) {
		Cart c = cs.getById(id);
		int quantity = c.getQuantity()+1;
		c.setQuantity(quantity);

		
		/* for updating individual product price */ 
		
		Product p =c.getProduct();
		double price = p.getPrice()*quantity;
		c.setSubTotal(price);
		cr.updateCartSubTotal(price, id);
		System.out.println("Price=" +price);
		
		
		/* for updating individual product quantity */ 
		
		System.out.println("QUantity="+quantity);
		cr.updateCartQuantity(quantity, id);
		return "redirect:/cart";
	}
	@GetMapping("/decreaseQuantity")
	private String decreaseQuantity(@RequestParam int id) {
		Cart c = cs.getById(id);
		int quantity = c.getQuantity()-1;
		c.setQuantity(quantity);
		
		/* for updating individual product price */ 
		
	Product p =c.getProduct();
	double price = p.getPrice()*quantity;
	c.setSubTotal(price);
	cr.updateCartSubTotal(price, id);
	System.out.println("Price=" +price);
	
		
		System.out.println(quantity);
		cr.updateCartQuantity(quantity, id);

		return "redirect:/cart";
	}
}


















