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
public class ProductionView {

    private Integer id;
    private LocalDate date;
    private BigDecimal quantity;
    private Integer quantityCount;
    private String notes;
    private String unitOfMeasureSymbol;
    private String unitOfMeasureId;
    private String productionUnitName;
    private Integer productionUnitId;

}
