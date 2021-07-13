package com.example.couse.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.couse.entites.User;
import com.example.couse.repositories.UserReposity;

@Service
public class UserService {

	@Autowired
	private UserReposity reposity;

	public List<User> findAll() {
		return reposity.findAll();

	}
	
	public User findById(Long id) {
		Optional<User> obj = reposity.findById(id);
		return obj.get();
	}
	
	public User inset(User obj) {
		return reposity.save(obj);
	}

}
