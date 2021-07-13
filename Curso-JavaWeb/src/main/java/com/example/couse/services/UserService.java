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

	public void delete(Long id) {
		reposity.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = reposity.getOne(id);
		updateData(entity,obj);
		return reposity.save(entity);
		}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
