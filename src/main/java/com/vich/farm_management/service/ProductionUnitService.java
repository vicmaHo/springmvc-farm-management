package com.vich.farm_management.service;

import java.util.List;

import com.vich.farm_management.controller.dto.ProductionUnitRequest;
import com.vich.farm_management.controller.dto.ProductionUnitResponse;


public interface ProductionUnitService {

    void saveProductionUnit(ProductionUnitRequest value);

    ProductionUnitResponse getProductionUnitById(Integer id);

    List<ProductionUnitResponse> getAllProductionUnits();

    void updateProductionUnit(ProductionUnitRequest value, Integer id);

    void deleteProductionUnit(Integer id);

}
