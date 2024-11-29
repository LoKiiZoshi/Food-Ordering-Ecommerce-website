package com.FreshTastyBitesHouseWeb.springboot.FTBHW.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.User;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.repository.UserRepository;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.UserService;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserRepository ur;

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		ur.save(user);
	} 

	@Override
	public User loginUser(String un, String pw) {
		return ur.findByUsernameAndPassword(un, pw);
	}

	@Override
	public User doesUserExist(String un) {
		return ur.findByUsername(un);
	}

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return ur.findById(id);
	}

	@Override
	public boolean checkUserExists(String username) {
		return ur.existsByUsername(username);
	}

	@Override
	public void signup(User user) {
		// TODO Auto-generated method stub
		ur.save(user);
	}

	@Override
	public User authenticate(String username, String password) {
		// TODO Auto-generated method stub
		return ur.findByUsernameAndPassword(username, password); 
	}



}
