package com.example.couse.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.couse.entites.User;
import com.example.couse.repositories.UserReposity;
import com.example.couse.services.exceptions.DatabaseException;
import com.example.couse.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {

	@Autowired
	private UserReposity reposity;

	public List<User> findAll() {
		return reposity.findAll();

	}

	public User findById(Long id) {
		Optional<User> obj = reposity.findById(id);
		return obj.orElseThrow(()-> new ResourceNotFoundException(id));
	}

	public User inset(User obj) {
		return reposity.save(obj);
	}

	public void delete(Long id) {
		try {
		reposity.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public User update(Long id, User obj) {
		try {
		User entity = reposity.getOne(id);
		updateData(entity,obj);
		return reposity.save(entity);
		}catch(EntityNotFoundException e){
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
}
