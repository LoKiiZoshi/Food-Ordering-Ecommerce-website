package com.FreshTastyBitesHouseWeb.springboot.FTBHW.model;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.contants.CartStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="cart_tbl")
public class Cart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="product_id")
	public Product product;
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	@Enumerated(EnumType.STRING)
	private CartStatus status;
	private int quantity; 
	private double subTotal;
	
	
}
