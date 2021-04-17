package com.wolkensoftware.AadharSpringBoot.service;

import com.wolkensoftware.AadharSpringBoot.entity.AadharEntity;

public interface AadharService {

	public AadharEntity validateAndAddPerson(AadharEntity aadharEntity);

}
