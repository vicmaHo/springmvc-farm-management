package com.vich.farm_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.vich.farm_management.controller.dto.UnitOfMeasureRequest;
import com.vich.farm_management.controller.dto.UnitOfMeasureResponse;
import com.vich.farm_management.model.UnitOfMeasure;
import com.vich.farm_management.repository.UnitOfMeasureRepository;

public class UnitOfMeasureServiceImpl implements UnitOfMeasureService {

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Override
    public void saveUnitOfMeasure(UnitOfMeasureRequest value) {
        
        UnitOfMeasure newUnitOfMeasure = new UnitOfMeasure();
        newUnitOfMeasure.setName(value.getName());
        newUnitOfMeasure.setSymbol(value.getSymbol());
        unitOfMeasureRepository.save(newUnitOfMeasure);

    }

    @Override
    public List<UnitOfMeasureResponse> getAllUnitOfMeasures() {
        List<UnitOfMeasure> unitOfMeasures = unitOfMeasureRepository.findAll();
        return unitOfMeasures.stream().map(unitOfMeasure -> {
            UnitOfMeasureResponse unitOfMeasureResponse = new UnitOfMeasureResponse();
            unitOfMeasureResponse.setId(unitOfMeasure.getId());
            unitOfMeasureResponse.setName(unitOfMeasure.getName());
            unitOfMeasureResponse.setSymbol(unitOfMeasure.getSymbol());
            return unitOfMeasureResponse;
        }).toList();
    }

    @Override
    public UnitOfMeasureResponse getUnitOfMeasureById(Integer id) {
        
        UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findById(id).orElse(null);
        if (unitOfMeasure == null) {
            throw new IllegalArgumentException("UnitOfMeasure not found with ID: " + id);
        }
        UnitOfMeasureResponse unitOfMeasureResponse = new UnitOfMeasureResponse();
        unitOfMeasureResponse.setId(unitOfMeasure.getId());
        unitOfMeasureResponse.setName(unitOfMeasure.getName());
        unitOfMeasureResponse.setSymbol(unitOfMeasure.getSymbol());
        return unitOfMeasureResponse;
    }

    @Override
    public void updateUnitOfMeasure(UnitOfMeasureRequest value, Integer id) {
        UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findById(id).orElse(null);
        if (unitOfMeasure == null) {
            throw new IllegalArgumentException("UnitOfMeasure not found with ID: " + id);
        }
        unitOfMeasure.setName(value.getName());
        unitOfMeasure.setSymbol(value.getSymbol());
        unitOfMeasureRepository.save(unitOfMeasure);
    }

    @Override
    public void deleteUnitOfMeasure(Integer id) {
        unitOfMeasureRepository.deleteById(id);
    }

}
