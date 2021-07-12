package com.example.couse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.couse.entites.Category;
import com.example.couse.repositories.CategoryReposity;

@Service
public class CategoryService {

	@Autowired
	private CategoryReposity reposity;

	public List<Category> findAll() {
		return reposity.findAll();

	}

	public Category findById(Long id) {
		Optional<Category> obj = reposity.findById(id);
		return obj.get();
	}

}
