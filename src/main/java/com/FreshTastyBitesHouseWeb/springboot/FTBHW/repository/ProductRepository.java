package com.FreshTastyBitesHouseWeb.springboot.FTBHW.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
List<Product> findByCategory(String category);
Product findById(int id);
List<Product> findByTitle(String title);


//@Query ("select p from product where p.title like =?1")
//List<Product> findBySearch(String sData);


@Query("SELECT p FROM Product p WHERE p.title LIKE %?1%")
List<Product> findAll(String sdata); 

}
