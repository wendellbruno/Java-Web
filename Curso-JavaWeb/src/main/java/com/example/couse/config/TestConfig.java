package com.example.couse.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.couse.entites.Category;
import com.example.couse.entites.Order;
import com.example.couse.entites.User;
import com.example.couse.entites.enums.OrderStatus;
import com.example.couse.repositories.CategoryReposity;
import com.example.couse.repositories.OrderReposity;
import com.example.couse.repositories.UserReposity;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	@Autowired
	private UserReposity userReposity;
	
	@Autowired
	private OrderReposity orderReposity;
	
	@Autowired
	private CategoryReposity categoryReposity;

	@Override
	public void run(String... args) throws Exception {
		
		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryReposity.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"),OrderStatus.WAITING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"),OrderStatus.DELIVERY, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"),OrderStatus.SHIPPED,u1);
		
		userReposity.saveAll(Arrays.asList(u1,u2));
		orderReposity.saveAll(Arrays.asList(o1,o2,o3));
	}
	
	

}
