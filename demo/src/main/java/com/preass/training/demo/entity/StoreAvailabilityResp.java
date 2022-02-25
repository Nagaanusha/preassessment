package com.preass.training.demo.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@AllArgsConstructor
public class StoreAvailabilityResp {

	private String storeID;
	private LocalDateTime requestDate;
	private String status;
}
