package com.preass.training.demo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Product {
	
	private String productId;
	private String productName;
	private String unitOfMeasure;
	private Date launchDate;

}
