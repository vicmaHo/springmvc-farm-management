package com.vich.farm_management.service;

import java.util.List;

import com.vich.farm_management.controller.dto.ProductionRequest;
import com.vich.farm_management.controller.dto.ProductionResponse;
import com.vich.farm_management.controller.dto.ProductionView;

public interface ProductionService {

    void saveProduction(ProductionRequest value);

    List<ProductionView> getAllProductions();

    ProductionResponse getProductionById(Integer id);

    void updateProduction(ProductionRequest value, Integer id);

    void deleteProduction(Integer id);
}
