package com.nt.runners;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.model.prod.Product;
import com.nt.model.promotions.Offers;
import com.nt.repo.prod.IProductRepo;
import com.nt.repo.promotions.IOffersRepo;

@Component
public class MultiDataSourceRunner implements CommandLineRunner {

	@Autowired
	private IProductRepo prodRepo;

	@Autowired
	private IOffersRepo offerRepo;

	@Override
	public void run(String... args) throws Exception {

		// save object
		prodRepo.saveAll(Arrays.asList(new Product("table", 12.0, 12000.0), new Product("chair", 10.0, 34000.0),
				new Product("sofa", 4.0, 23000.0)));
		System.out.println("products are saved.");
		System.out.println("=======================");
		offerRepo.saveAll(Arrays.asList(
				new Offers("BUY1-GET1", "B1G1", 100.0, LocalDateTime.now()),
				new Offers("BUY2-GET1", "B1G1", 50.0, LocalDateTime.now())
				));
		System.out.println("offers are saved.");
		System.out.println("=======================");
		
		System.out.println("===============Display Products========");
		prodRepo.findAll().forEach(System.out::println);
		System.out.println("===============Display Offers========");
		offerRepo.findAll().forEach(System.out::println);
	}

}
