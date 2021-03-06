package com.wolkensoftware.AadharSpringBoot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "aadhar_details")
public class AadharEntity { // Parent

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "pincode")
	private int pincode;

	@Column(name = "number")
	private double number;

	@Column(name = "area")
	private String area;

	@OneToOne
	@JoinColumn(name = "id")
	@JsonIgnoreProperties("aadharEntity")
	private PANEntity panEntity;

}
