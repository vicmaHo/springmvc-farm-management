package com.vich.farm_management.service;

import java.util.List;

import com.vich.farm_management.controller.dto.UnitOfMeasureRequest;
import com.vich.farm_management.controller.dto.UnitOfMeasureResponse;

public interface UnitOfMeasureService {

    void saveUnitOfMeasure(UnitOfMeasureRequest value);

    List<UnitOfMeasureResponse> getAllUnitOfMeasures();

    UnitOfMeasureResponse getUnitOfMeasureById(Integer id);

    void updateUnitOfMeasure(UnitOfMeasureRequest value, Integer id);

    void deleteUnitOfMeasure(Integer id);

    

}
