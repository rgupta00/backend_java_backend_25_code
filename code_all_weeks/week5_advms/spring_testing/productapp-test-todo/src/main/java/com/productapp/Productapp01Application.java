package com.productapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.productapp.repo.Product;
import com.productapp.repo.ProductRepo;
import com.productapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication

public class Productapp01Application implements CommandLineRunner {

//	@Autowired
//	private ProductRepo productRepo;

//	@Autowired
//	private ObjectMapper objectMapper;


	public static void main(String[] args) {
		SpringApplication.run(Productapp01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Product product=new Product(1,"laptop",120000);
//		String data=objectMapper.writeValueAsString(product);
//		System.out.println(data);
//
//		Product productFromJson=objectMapper.readValue(data, Product.class);
//		System.out.println(productFromJson);

//			productRepo.save(new Product("laptop",120000));
//		    productRepo.save(new Product("mobile",50000));
//		System.out.println("------------------------------");
	}
}
