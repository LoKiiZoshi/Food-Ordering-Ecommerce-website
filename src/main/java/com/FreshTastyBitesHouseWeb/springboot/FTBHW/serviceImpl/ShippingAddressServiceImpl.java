package com.FreshTastyBitesHouseWeb.springboot.FTBHW.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.ShippingAddress;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.repository.ShippingAddressRepository;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.service.ShippingAddressService;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService{
@Autowired
private ShippingAddressRepository sar;

	@Override
	public void addShippingAddress(ShippingAddress shippingAddress) {
		// TODO Auto-generated method stub
		sar.save(shippingAddress); 
	}

}
