package com.preass.training.demo.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class Capacity {

	private String storeNo;
	private Date date;
	private String productId;
	private Double noOfOrdersAccepted;
}
