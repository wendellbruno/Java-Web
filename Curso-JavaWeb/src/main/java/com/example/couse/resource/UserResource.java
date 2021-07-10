package com.example.couse.resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.couse.entites.User;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@GetMapping
	public  ResponseEntity<User> findAll(){
		User u = new User(1L,"Maria","MAria@gmail.com","9999","123");
		return ResponseEntity.ok().body(u);
	}
}
