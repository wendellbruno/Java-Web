package com.example.couse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.couse.entites.Order;
import com.example.couse.repositories.OrderReposity;

@Service
public class OrderService {

	@Autowired
	private OrderReposity reposity;

	public List<Order> findAll() {
		return reposity.findAll();

	}
	
	public Order findById(Long id) {
		Optional<Order> obj = reposity.findById(id);
		return obj.get();
	}

}
