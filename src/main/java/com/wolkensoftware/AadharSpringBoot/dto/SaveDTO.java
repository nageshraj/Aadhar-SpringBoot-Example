package com.wolkensoftware.AadharSpringBoot.dto;

import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class SaveDTO {

	private String name;
	private int pincode;
	private double number;
	private String area;
	private double panNumber;

}
