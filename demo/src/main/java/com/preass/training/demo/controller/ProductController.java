package com.preass.training.demo.controller;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preass.training.demo.entity.Product;
import com.preass.training.demo.entity.ProductList;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/sortProducts")
@Slf4j
public class ProductController {

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> sortProducts(@RequestBody ProductList productList){
		
		log.info("Calling API /sortProducts");
		
		//LaunchDate Comparator
		Comparator<Product> compareByName = Comparator
                .comparing(Product::getLaunchDate);

		//Sorting based on launchDate comparator
		List<Product> sortedProducts = productList.getProductList().stream()
            .sorted(compareByName.reversed())
            .collect(Collectors.toList());

		return ResponseEntity.status(HttpStatus.CREATED).body(sortedProducts);
		
	}
}
