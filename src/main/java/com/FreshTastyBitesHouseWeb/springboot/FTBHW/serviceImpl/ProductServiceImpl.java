package com.FreshTastyBitesHouseWeb.springboot.FTBHW.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.Product;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.repository.ProductRepository;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.ProductService;
@Service 
public class ProductServiceImpl  implements ProductService{
	@Autowired
	ProductRepository pr; 
	
	
	@Override
	public List<Product> pListByCategory(String category) {
		// TODO Auto-generated method stub
		List<Product> jList= pr.findByCategory(category);
		return jList;
	}

	@Override
	public List<Product> getAll() {
		// TODO Auto-generated method stub
		return pr.findAll();
	}

	@Override
	public Product getById(int id) {
		// TODO Auto-generated method stub
		return pr.findById(id);
	}


	@Override
	public List<Product> pListForSearch(String sData) {
		// TODO Auto-generated method stub
		List<Product> sList= pr.findByTitle(sData);
		return sList;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		pr.deleteById(id);
	}

	@Override
	public void addproduct(Product product) {
		pr.save(product);
		
	}
	
	

}
