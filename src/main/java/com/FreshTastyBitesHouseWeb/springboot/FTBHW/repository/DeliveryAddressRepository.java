package com.FreshTastyBitesHouseWeb.springboot.FTBHW.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.FreshTastyBitesHouseWeb.springboot.FTBHW.model.DeliveryAddress;

public interface DeliveryAddressRepository extends JpaRepository<DeliveryAddress, Integer>{
DeliveryAddress findById(int dId);
}
