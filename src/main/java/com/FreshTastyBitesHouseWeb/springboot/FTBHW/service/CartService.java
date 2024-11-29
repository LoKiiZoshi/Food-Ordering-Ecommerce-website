package com.FreshTastyBitesHouseWeb.springboot.FTBHW.service;

import java.util.List;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Cart;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.User;

public interface CartService {
void addCart(Cart cart);
List<Cart> getAllCart();
void deleteById(int id);
List<Cart> getByUser(User user);
Cart getById(int id);

}
