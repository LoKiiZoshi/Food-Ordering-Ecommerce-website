package com.FreshTastyBitesHouseWeb.springboot.FTBHW.service;

import java.util.List;

import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.DeliveryAddress;

public interface DeliveryAddressService {
void addBillingAddress(DeliveryAddress deliveryAddress);
List<DeliveryAddress> getAllAddress();
DeliveryAddress getAddressById(int dId);
void deleteById(int dId);      
}
