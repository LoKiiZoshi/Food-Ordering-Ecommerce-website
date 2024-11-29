package com.FreshTastyBitesHouseWeb.springboot.FTBHW.repository;
import org.springframework.data.jpa.repository.JpaRepository;


import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.User;


public interface UserRepository extends JpaRepository<User, Integer>{
User findByUsernameAndPassword(String un,String pw);
User findByUsername(String un);
User findById(int id);

boolean existsByUsername(String username);
}
