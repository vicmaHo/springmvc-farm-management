package com.vich.farm_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vich.farm_management.model.MovementType;


public interface MovementTypeRepository extends JpaRepository<MovementType, Integer> {

}
