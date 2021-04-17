package com.wolkensoftware.AadharSpringBoot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolkensoftware.AadharSpringBoot.Repository.AadharRepository;
import com.wolkensoftware.AadharSpringBoot.entity.AadharEntity;

@Service
public class AadharServiceImpl implements AadharService {

	@Autowired
	AadharRepository aadharRepository;

	@Override
	public AadharEntity validateAndAddPerson(AadharEntity aadharEntity) {
		// TODO Auto-generated method stub
		System.out.println("Inside Validate");
		return aadharRepository.save(aadharEntity);
	}

}
