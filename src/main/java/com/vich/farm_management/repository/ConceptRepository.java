package com.vich.farm_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vich.farm_management.model.Concept;

public interface ConceptRepository extends JpaRepository<Concept, Integer> {

}
