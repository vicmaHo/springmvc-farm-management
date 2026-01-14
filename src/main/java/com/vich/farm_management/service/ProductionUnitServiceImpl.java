package com.vich.farm_management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vich.farm_management.controller.dto.ProductionUnitRequest;
import com.vich.farm_management.controller.dto.ProductionUnitResponse;
import com.vich.farm_management.model.ProductionUnit;
import com.vich.farm_management.repository.ProductionUnitRepository;

@Service
public class ProductionUnitServiceImpl implements ProductionUnitService {

    @Autowired
    private ProductionUnitRepository productionUnitRepository;

    @Override
    public void saveProductionUnit(ProductionUnitRequest value) {
        ProductionUnit newProductionUnit = new ProductionUnit();
        newProductionUnit.setName(value.getName());
        productionUnitRepository.save(newProductionUnit);
    }

    @Override
    public ProductionUnitResponse getProductionUnitById(Integer id) {
       ProductionUnit productionUnit = productionUnitRepository.findById(id).orElse(null);

        if (productionUnit == null) {
            throw new IllegalArgumentException("ProductionUnit not found with ID: " + id);
        }
        ProductionUnitResponse productionUnitResponse = new ProductionUnitResponse();
        productionUnitResponse.setId(productionUnit.getId());
        productionUnitResponse.setName(productionUnit.getName());
        return productionUnitResponse;
    }

    @Override
    public List<ProductionUnitResponse> getAllProductionUnits() {
        List<ProductionUnit> productionUnits = productionUnitRepository.findAll();
        return productionUnits.stream().map(productionUnit -> {
            ProductionUnitResponse productionUnitResponse = new ProductionUnitResponse();
            productionUnitResponse.setId(productionUnit.getId());
            productionUnitResponse.setName(productionUnit.getName());
            return productionUnitResponse;
        }).toList();
    }

    @Override
    public void updateProductionUnit(ProductionUnitRequest value, Integer id) {
        ProductionUnit productionUnit = productionUnitRepository.findById(id).orElse(null);
        if (productionUnit == null) {
            throw new IllegalArgumentException("ProductionUnit not found with ID: " + id);
        }
        productionUnit.setName(value.getName());
        productionUnitRepository.save(productionUnit);
    }

    @Override
    public void deleteProductionUnit(Integer id) {
        productionUnitRepository.deleteById(id);
    }

}
