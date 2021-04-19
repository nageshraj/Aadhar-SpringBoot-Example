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
	public boolean validateAndUpdatePincodeByName(int newPincode, String nameToUpdate) {

		System.out.println("name is " + nameToUpdate);
		AadharEntity aadharEntity = aadharRepository.findByName(nameToUpdate);

		aadharEntity.setPincode(newPincode);
		aadharEntity = aadharRepository.save(aadharEntity);
		if (aadharEntity != null)
			return true;
		else
			return false;
	}

	@Override
	public String validateAndDeleteByName(String nameToDelete) {

		aadharRepository.delete(aadharRepository.findByName(nameToDelete));

		return nameToDelete + " Deleted Successfully";
	}

	@Override
	public List<AadharEntity> validateAndGetAllByArea(String area) {
		return aadharRepository.findByArea(area);

	}

	@Override
	public int validateAndAddPersons(SaveDTO[] saveDTOs) {

		int count = 0;

		for (SaveDTO saveDTO : saveDTOs) {

			PANEntity panEntity = panRepository.findByPanNumber(saveDTO.getPanNumber());

			AadharEntity aadharEntity = new AadharEntity();
			aadharEntity.setName(saveDTO.getName());
			aadharEntity.setArea(saveDTO.getArea());
			aadharEntity.setNumber(saveDTO.getNumber());
			aadharEntity.setPincode(saveDTO.getPincode());
			aadharEntity.setPanEntity(panEntity);

			aadharRepository.save(aadharEntity);

			count++;

		}
		return count;
	}

	@Override
	public PANEntity validateAndUpdatePanCityByPanNumber(String newCity, double panNumber, double panPinCode,
			String panName) {

		PANEntity panEntity = panRepository.findByPanNumber(panNumber);
		panEntity.setPanCity(newCity);
		panEntity.setPanPincode(panPinCode);
		panEntity.setPanName(panName);
		return panRepository.save(panEntity);

	}

	@Override
	public AadharEntity validateAndGetAllByAreaOrName(String name, String area) {

		AadharEntity aadharEntity = aadharRepository.findByNameOrArea(name, area);

		return aadharEntity;
	}

	@Override
	public List<PANEntity> validateAndGetAllByPanNameOrPanNumberOrPanCityOrpanPincode(String panName, double panNumber,
			String panCity, double panPincode) {

		List<PANEntity> panEntities = panRepository.findByPanNameOrPanNumberOrPanCityOrPanPincode(panName, panNumber,
				panCity, panPincode);

		return panEntities;
	}

}
