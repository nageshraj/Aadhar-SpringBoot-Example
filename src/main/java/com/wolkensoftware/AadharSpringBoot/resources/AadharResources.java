package com.wolkensoftware.AadharSpringBoot.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wolkensoftware.AadharSpringBoot.entity.AadharEntity;
import com.wolkensoftware.AadharSpringBoot.service.AadharService;

@RestController
@RequestMapping("/")
public class AadharResources {

	@Autowired
	AadharService aadharService;

	@RequestMapping("/add")
	public AadharEntity addPerson(@RequestBody AadharEntity aadharEntity) {
		return aadharService.validateAndAddPerson(aadharEntity);

	}

}
