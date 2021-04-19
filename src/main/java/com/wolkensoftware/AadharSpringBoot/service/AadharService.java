package com.wolkensoftware.AadharSpringBoot.service;

import java.util.List;

import com.wolkensoftware.AadharSpringBoot.dto.SaveDTO;
import com.wolkensoftware.AadharSpringBoot.entity.AadharEntity;
import com.wolkensoftware.AadharSpringBoot.entity.PANEntity;

public interface AadharService {

	public AadharEntity validateAndAddPerson(SaveDTO saveDTO);

	public int validateAndAddPersons(SaveDTO[] saveDTOs);

	public List<AadharEntity> validateAndGetAll();

	public List<AadharEntity> validateAndGetAllByArea(String area);

	public boolean validateAndUpdatePincodeByName(int newPincode, String nameToUpdate);

	public String validateAndDeleteByName(String nameToDelete);

	public PANEntity validateAndUpdatePanCityByPanNumber(String newCity, double panNumber, double panPinCode,
			String panName);

	public AadharEntity validateAndGetAllByAreaOrName(String name, String area);

	public List<PANEntity> validateAndGetAllByPanNameOrPanNumberOrPanCityOrpanPincode(String panName, double panNumber,
			String panCity, double panPincode);

}
