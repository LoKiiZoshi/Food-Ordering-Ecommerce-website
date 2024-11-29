package com.FreshTastyBitesHouseWeb.springboot.FTBHW.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table
@Data
public class DeliveryAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String address;
	private String city;
	private String country;
	private String zipCode;
	private String telephone;
	@OneToOne
	@JoinColumn(name="user_id")
	private User user;
	private String note;
	private Date date;
	@ManyToMany 
	private List<Product> productsIdList;
	@ElementCollection
    @CollectionTable(name="delivery_quantity", joinColumns=@JoinColumn(name="delivery_id"))
    @Column(name="quantity")
    private List<Integer> quantity;
    private	Double total;
}
