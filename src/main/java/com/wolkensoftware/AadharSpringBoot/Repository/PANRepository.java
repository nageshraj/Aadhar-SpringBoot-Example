package com.wolkensoftware.AadharSpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolkensoftware.AadharSpringBoot.entity.PANEntity;

public interface PANRepository extends JpaRepository<PANEntity, Integer> {

	public PANEntity findByPanNumber(double panNumberToFind);

}
