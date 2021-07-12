package com.example.couse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.couse.entites.Product;
import com.example.couse.repositories.ProductReposity;

@Service
public class ProductService {

	@Autowired
	private ProductReposity reposity;

	public List<Product> findAll() {
		return reposity.findAll();

	}
	
	public Product findById(Long id) {
		Optional<Product> obj = reposity.findById(id);
		return obj.get();
	}

}
