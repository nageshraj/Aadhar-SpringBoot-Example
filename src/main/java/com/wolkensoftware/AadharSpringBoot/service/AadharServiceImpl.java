package com.wolkensoftware.AadharSpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wolkensoftware.AadharSpringBoot.Repository.AadharRepository;
import com.wolkensoftware.AadharSpringBoot.Repository.PANRepository;
import com.wolkensoftware.AadharSpringBoot.dto.SaveDTO;
import com.wolkensoftware.AadharSpringBoot.entity.AadharEntity;
import com.wolkensoftware.AadharSpringBoot.entity.PANEntity;

@Service
public class AadharServiceImpl implements AadharService {

	@Autowired
	AadharRepository aadharRepository;

	@Autowired
	PANRepository panRepository;

	@Override
	public AadharEntity validateAndAddPerson(SaveDTO saveDTO) {
		System.out.println("Inside Validate");

		PANEntity panEntity = panRepository.findByPanNumber(saveDTO.getPanNumber());
		AadharEntity aadharEntity = new AadharEntity();
		aadharEntity.setName(saveDTO.getName());
		aadharEntity.setArea(saveDTO.getArea());
		aadharEntity.setNumber(saveDTO.getNumber());
		aadharEntity.setPincode(saveDTO.getPincode());
		aadharEntity.setPanEntity(panEntity);

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

		return nameToDelete + " Deleted Successfully";
	}

}
