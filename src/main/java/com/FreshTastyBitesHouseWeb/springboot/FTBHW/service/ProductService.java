package com.FreshTastyBitesHouseWeb.springboot.FTBHW.service;

import java.util.List;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Product;

public interface ProductService {
void addproduct(Product product);
List<Product> pListByCategory(String category);
List<Product> getAll();
Product getById(int id);
List<Product> pListForSearch(String sData);
void deleteById(int id);


}
