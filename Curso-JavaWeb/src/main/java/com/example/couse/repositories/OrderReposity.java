package com.example.couse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.couse.entites.Order;

public interface OrderReposity extends JpaRepository<Order, Long>{


 }
