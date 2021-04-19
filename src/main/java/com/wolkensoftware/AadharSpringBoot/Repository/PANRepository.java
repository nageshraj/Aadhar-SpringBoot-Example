package com.wolkensoftware.AadharSpringBoot.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolkensoftware.AadharSpringBoot.entity.PANEntity;

public interface PANRepository extends JpaRepository<PANEntity, Integer> {

	public PANEntity findByPanNumber(double panNumberToFind);

	public List<PANEntity> findByPanNameOrPanNumberOrPanCityOrPanPincode(String panName, double panNumber,
			String panCity, double panPincode);

}
