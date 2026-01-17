package com.vich.farm_management.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "unit_of_measure")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UnitOfMeasure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "unit_of_measure_name", nullable = false, unique = true)
    private String name;

    @Column(name = "unit_of_measure_symbol", nullable = false, unique = true)
    private String symbol;

}
