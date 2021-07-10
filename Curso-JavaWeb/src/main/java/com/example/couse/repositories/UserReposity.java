package com.example.couse.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.couse.entites.User;

public interface UserReposity extends JpaRepository<User, Long>{


 }
