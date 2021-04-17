package com.wolkensoftware.AadharSpringBoot.service;

import java.util.List;

import com.wolkensoftware.AadharSpringBoot.entity.AadharEntity;

public interface AadharService {

	public AadharEntity validateAndAddPerson(AadharEntity aadharEntity);

	public List<AadharEntity> validateAndGetAll();

	public AadharEntity validateAndUpdatePincodeByName(int newPincode, String nameToUpdate);

	public String validateAndDeleteByName(String nameToDelete);

}
