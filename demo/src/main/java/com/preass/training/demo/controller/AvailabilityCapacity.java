package com.preass.training.demo.controller;

import java.util.List;

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
@RequestMapping("/getProdAvailability")
@Slf4j
public class AvailabilityCapacity {

	//@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	//public ResponseEntity<> sortProducts(@RequestBody ProductList productList){
}
