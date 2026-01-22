package com.vich.farm_management.controller.dto;


import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductionRequest {

    private LocalDate date;
    private BigDecimal quantity;
    private Integer quantityCount;
    private String notes;
    private Integer unitOfMeasureId;
    private Integer productionUnitId;

}
