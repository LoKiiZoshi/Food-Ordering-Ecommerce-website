package com.FreshTastyBitesHouseWeb.springboot.FTBHW.service;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.User;

public interface UserService {
	public void addUser(User user);
	User loginUser(String un, String pw); 
	public User doesUserExist(String un);
	User getUserById(int id);
	boolean checkUserExists(String username);
	void signup(User user);  
	User authenticate(String username, String password); 
}
