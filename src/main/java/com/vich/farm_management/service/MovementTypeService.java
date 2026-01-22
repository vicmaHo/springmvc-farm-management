package com.vich.farm_management.service;

import java.util.List;

import com.vich.farm_management.controller.dto.MovementTypeRequest;
import com.vich.farm_management.controller.dto.MovementTypeResponse;

public interface MovementTypeService {

    void saveMovementType(MovementTypeRequest value);

    List<MovementTypeResponse> getAllMovementTypes();

    MovementTypeResponse getMovementTypeById(Integer id);

    void deleteMovementType(Integer id);

    void updateMovementType(MovementTypeRequest value, Integer id);

}
