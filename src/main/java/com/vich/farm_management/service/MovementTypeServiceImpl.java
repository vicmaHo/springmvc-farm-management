package com.vich.farm_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vich.farm_management.controller.dto.MovementTypeRequest;
import com.vich.farm_management.controller.dto.MovementTypeResponse;
import com.vich.farm_management.model.MovementType;
import com.vich.farm_management.repository.MovementTypeRepository;

@Service
public class MovementTypeServiceImpl implements MovementTypeService {

    @Autowired
    private MovementTypeRepository movementTypeRepository;

    @Override
    public void saveMovementType(MovementTypeRequest value) {
        
        MovementType newMovementType = new MovementType();
        newMovementType.setName(value.getName());
        movementTypeRepository.save(newMovementType);
    }

    @Override
    public List<MovementTypeResponse> getAllMovementTypes() {
        
        List<MovementType> movementTypes = movementTypeRepository.findAll();
        return movementTypes.stream().map(movementType -> {
            MovementTypeResponse movementTypeResponse = new MovementTypeResponse();
            movementTypeResponse.setId(movementType.getId());
            movementTypeResponse.setName(movementType.getName());
            return movementTypeResponse;
        }).toList();
    }

    @Override
    public MovementTypeResponse getMovementTypeById(Integer id) {
        MovementType movementType = movementTypeRepository.findById(id).orElse(null);
        if (movementType == null) {
            throw new IllegalArgumentException("MovementType not found with ID: " + id);
        }
        MovementTypeResponse movementTypeResponse = new MovementTypeResponse();
        movementTypeResponse.setId(movementType.getId());
        movementTypeResponse.setName(movementType.getName());
        return movementTypeResponse;
    }

    @Override
    public void deleteMovementType(Integer id) {
        movementTypeRepository.deleteById(id);
    }

    @Override
    public void updateMovementType(MovementTypeRequest value, Integer id) {
        
        MovementType movementType = movementTypeRepository.findById(id).orElse(null);
        if (movementType == null) {
            throw new IllegalArgumentException("MovementType not found with ID: " + id);
        }
        movementType.setName(value.getName());
        movementTypeRepository.save(movementType);
    }

}
