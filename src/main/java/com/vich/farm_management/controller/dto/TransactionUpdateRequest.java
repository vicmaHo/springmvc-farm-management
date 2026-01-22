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
public class TransactionUpdateRequest {

    private Integer id;
    private LocalDate date;
    private BigDecimal amount;
    private String description;
    private Integer conceptId;
    private Integer productionUnitId;

}
