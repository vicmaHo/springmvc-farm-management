package com.vich.farm_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vich.farm_management.controller.dto.ConceptRequest;
import com.vich.farm_management.controller.dto.ConceptResponse;
import com.vich.farm_management.model.Concept;
import com.vich.farm_management.model.MovementType;
import com.vich.farm_management.repository.ConceptRepository;
import com.vich.farm_management.repository.MovementTypeRepository;

@Service
public class ConcetpServiceImpl implements ConceptService {

    @Autowired
    private ConceptRepository conceptRepository;

    @Autowired
    private MovementTypeRepository movementTypeRepository;

    @Override
    public void saveConcept(ConceptRequest value) {

        MovementType movementType = movementTypeRepository.findById(value.getMovementTypeId()).orElse(null);
        if (movementType == null) {
            throw new IllegalArgumentException("MovementType not found with ID: " + value.getMovementTypeId());
        }

        Concept concept = new Concept();
        concept.setName(value.getName());
        concept.setMovementType(movementType);
        conceptRepository.save(concept);
    }

    @Override
    public List<ConceptResponse> getAllConcepts() {
        
        List<Concept> concepts = conceptRepository.findAll();
        return concepts.stream().map(concept -> {
            ConceptResponse conceptResponse = new ConceptResponse();
            conceptResponse.setId(concept.getId());
            conceptResponse.setName(concept.getName());
            conceptResponse.setMovementTypeId(concept.getMovementType().getId());
            return conceptResponse;
        }).toList();
    }

    @Override
    public ConceptResponse getConceptById(Integer ConceptId) {
        
        Concept concept = conceptRepository.findById(ConceptId).orElse(null);
        if (concept == null) {
            throw new IllegalArgumentException("Concept not found with ID: " + ConceptId);
        }
        ConceptResponse conceptResponse = new ConceptResponse();
        conceptResponse.setId(concept.getId());
        conceptResponse.setName(concept.getName());
        conceptResponse.setMovementTypeId(concept.getMovementType().getId());
        return conceptResponse;
    }

    @Override
    public void updateConcept(ConceptRequest value, Integer id) {
        
        Concept concept = conceptRepository.findById(id).orElse(null);
        if (concept == null) {
            throw new IllegalArgumentException("Concept not found with ID: " + id);
        }
        concept.setName(value.getName());
        conceptRepository.save(concept);
    }

    @Override
    public void deleteConcept(Integer id) {
        conceptRepository.deleteById(id);
    }

}
