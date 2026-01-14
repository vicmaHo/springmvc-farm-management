package com.vich.farm_management.service;

import java.util.List;

import com.vich.farm_management.controller.dto.ConceptRequest;
import com.vich.farm_management.controller.dto.ConceptResponse;



public interface ConceptService {

   
    void saveConcept(ConceptRequest value);

    List<ConceptResponse> getAllConcepts();

    ConceptResponse getConceptById(Integer id);

    void updateConcept(ConceptRequest value, Integer id);

    void deleteConcept(Integer id);

}
