package com.vich.farm_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vich.farm_management.controller.dto.ProductionRequest;
import com.vich.farm_management.controller.dto.ProductionResponse;
import com.vich.farm_management.model.Production;
import com.vich.farm_management.model.ProductionUnit;
import com.vich.farm_management.model.UnitOfMeasure;
import com.vich.farm_management.repository.ProductionRepository;
import com.vich.farm_management.repository.ProductionUnitRepository;
import com.vich.farm_management.repository.UnitOfMeasureRepository;

@Service
public class ProductionServiceImpl implements ProductionService {

    @Autowired
    private ProductionRepository productionRepository;

    @Autowired
    private UnitOfMeasureRepository unitOfMeasureRepository;

    @Autowired
    private ProductionUnitRepository productionUnitRepository;

    @Override
    public void saveProduction(ProductionRequest value) {

        UnitOfMeasure unitOfMeasure = unitOfMeasureRepository.findById(value.getUnitOfMeasureId()).orElse(null);
        if (unitOfMeasure == null) {
            throw new IllegalArgumentException("UnitOfMeasure not found with ID: " + value.getUnitOfMeasureId());
        }

        ProductionUnit productionUnit = productionUnitRepository.findById(value.getProductionUnitId()).orElse(null);
        if (productionUnit == null) {
            throw new IllegalArgumentException("ProductionUnit not found with ID: " + value.getProductionUnitId());
        }

        Production production = new Production();
        production.setDate(value.getDate());
        production.setQuantity(value.getQuantity());
        production.setNotes(value.getNotes());
        production.setUnitOfMeasure(unitOfMeasure);
        production.setProductionUnit(productionUnit);

        productionRepository.save(production);
    }

    @Override
    public List<ProductionResponse> getAllProductions() {
        
        List<Production> productions = productionRepository.findAll();
        return productions.stream().map(production -> {
            ProductionResponse productionResponse = new ProductionResponse();
            productionResponse.setId(production.getId());
            productionResponse.setDate(production.getDate());
            productionResponse.setQuantity(production.getQuantity());
            productionResponse.setNotes(production.getNotes());
            productionResponse.setUnitOfMeasureId(production.getUnitOfMeasure().getId());
            productionResponse.setProductionUnitId(production.getProductionUnit().getId());
            return productionResponse;
        }).toList();

    }

    @Override
    public ProductionResponse getProductionById(Integer id) {
        
        Production production = productionRepository.findById(id).orElse(null);
        if (production == null) {
            throw new IllegalArgumentException("Production not found with ID: " + id);
        }

        ProductionResponse response = new ProductionResponse();
        response.setId(production.getId());
        response.setDate(production.getDate());
        response.setQuantity(production.getQuantity());
        response.setNotes(production.getNotes());
        response.setUnitOfMeasureId(production.getUnitOfMeasure().getId());
        response.setProductionUnitId(production.getProductionUnit().getId());
        return response;
    }

    @Override
    public void updateProduction(ProductionRequest value, Integer id) {
        
        Production production = productionRepository.findById(id).orElse(null);
        if (production == null) {
            throw new IllegalArgumentException("Production not found with ID: " + id);
        }
        production.setDate(value.getDate());
        production.setQuantity(value.getQuantity());
        production.setNotes(value.getNotes());
        production.setUnitOfMeasure(unitOfMeasureRepository.findById(value.getUnitOfMeasureId()).orElse(null));
        production.setProductionUnit(productionUnitRepository.findById(value.getProductionUnitId()).orElse(null));
        productionRepository.save(production);
    }

    @Override
    public void deleteProduction(Integer id) {
        productionRepository.deleteById(id);
    }

}
