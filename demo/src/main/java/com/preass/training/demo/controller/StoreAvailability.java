package com.preass.training.demo.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.preass.training.demo.entity.Calendar;
import com.preass.training.demo.entity.ProductList;
import com.preass.training.demo.entity.StoreAvailabilityResp;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/findStoreAvailability")
@Slf4j
public class StoreAvailability {

		@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<StoreAvailabilityResp> storeAvailability(@RequestBody StoreAvailabilityResp sar){
			
			log.info("Initializing static store data" + sar.getStoreId());
			ArrayList<Calendar> stores = Stream
			        .of(new Calendar("STORE001", "ALL", LocalTime.parse("13:30")),new Calendar("Store002", "SUNDAY", LocalTime.parse("13:30")) , new Calendar("Store003", "MONDAY", LocalTime.parse("13:30")))
			        .collect(Collectors.toCollection(ArrayList::new));
			
			System.out.println("Day" + sar.getRequestDate().getDayOfWeek());
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");

			String timeString = sar.getRequestDate().format(formatter);
			
			System.out.println("Time" + LocalTime.parse(timeString));
			LocalTime storeTime =LocalTime.parse(timeString);
			 boolean isExists = stores.stream().
					anyMatch(e -> e.getLocationId().equals(sar.getStoreId()) &&
						(e.getDay().equals(sar.getRequestDate().getDayOfWeek().toString())||
						e.getDay().equals("ALL"))&& 
						e.getCustOffTime().compareTo(storeTime) <=0);
							
			
			if(isExists) {
				sar.setStatus("Available");
			}
			else {
				sar.setStatus("Not Available");
			}
			
			return ResponseEntity.status(HttpStatus.CREATED).body(sar);
			
		}
}
