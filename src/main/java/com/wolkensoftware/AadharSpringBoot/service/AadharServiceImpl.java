package com.wolkensoftware.AadharSpringBoot.service;

import java.util.List;

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
		System.out.println("Inside Validate");
		return aadharRepository.save(aadharEntity);
	}

	@Override
	public List<AadharEntity> validateAndGetAll() {
		return aadharRepository.findAll();
	}

	@Override
	public AadharEntity validateAndUpdatePincodeByName(int newPincode, String nameToUpdate) {

		AadharEntity aadharEntity = aadharRepository.findByName(nameToUpdate);
		aadharEntity.setPincode(newPincode);
		return aadharRepository.save(aadharEntity);
	}

	@Override
	public String validateAndDeleteByName(String nameToDelete) {

		aadharRepository.delete(aadharRepository.findByName(nameToDelete));

		return nameToDelete + "Deleted Successfully";
	}

}
