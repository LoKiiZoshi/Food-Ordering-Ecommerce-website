package com.FreshTastyBitesHouseWeb.springboot.FTBHW.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Cart;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.User;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.repository.CartRepository;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.CartService;
@Service
public class CartServiceImpl implements CartService{
	@Autowired
	CartRepository cr;
	@Override
	public void addCart(Cart cart) {
		// TODO Auto-generated method stub

		cr.save(cart);
	}
	@Override
	public List<Cart> getAllCart() {
		// TODO Auto-generated method stub
		return cr.findAll();
	}
	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		cr.deleteById(id);
	}
	@Override
	public List<Cart> getByUser(User user) {
		// TODO Auto-generated method stub
		return cr.findByUser(user);
	}
//	@Override
//	public List<Cart> getByUserAndStatus(User user, CartStatus status) {
//		// TODO Auto-generated method stub
//		return cr.findByUserAndStatus(user, status);
//	}
	@Override
	public Cart getById(int id) {
		// TODO Auto-generated method stub
		return cr.findById(id);
	}

}
