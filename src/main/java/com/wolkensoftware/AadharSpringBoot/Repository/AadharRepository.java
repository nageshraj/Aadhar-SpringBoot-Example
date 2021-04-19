package com.wolkensoftware.AadharSpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.wolkensoftware.AadharSpringBoot.entity.AadharEntity;

public interface AadharRepository extends JpaRepository<AadharEntity, Integer> {

	@Query(nativeQuery = true, value = "select ae.* from aadhar_details ae inner join pan_details as pe on ae.id=pe.id")
	public AadharEntity findByName(String name);

}
