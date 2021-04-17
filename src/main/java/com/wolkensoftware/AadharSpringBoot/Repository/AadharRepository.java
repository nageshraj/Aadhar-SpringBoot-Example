package com.wolkensoftware.AadharSpringBoot.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wolkensoftware.AadharSpringBoot.entity.AadharEntity;

public interface AadharRepository extends JpaRepository<AadharEntity, Integer> {

}
