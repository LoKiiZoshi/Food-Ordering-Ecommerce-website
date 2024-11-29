package com.FreshTastyBitesHouseWeb.springboot.FTBHW.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.contants.CartStatus;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Cart;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.User;

import jakarta.transaction.Transactional;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer>{
	
	/*
	 * @Transactional List<Cart> findByUserAndStatus(User user,CartStatus status);
	 */
	
	List<Cart>findByUserAndStatus(User user,CartStatus status);
//	@Query("select u from User u where u.emailAddress = ?1 and u.lastname = ?2")
	List<Cart> findByUser(User user);
	
	@Transactional
	@Modifying
	@Query("Update Cart set  status =:status where user.id =:uid ")
	void  updateCartStatusByUserId(Integer uid,CartStatus status);
	
	
	Cart findById(int id);
	
	@Transactional
	@Modifying
	@Query("Update Cart set quantity =:quantity where user.id =:id")
	void updateCartQuantity(Integer quantity,Integer id);
	
	@Transactional
	@Modifying
	@Query("Update Cart set subTotal =:subTotal where user.id =:id")
	void updateCartSubTotal(Double subTotal,Integer id);
}
