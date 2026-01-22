package com.vich.farm_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vich.farm_management.model.Production;

public interface ProductionRepository extends JpaRepository<Production, Integer>{


    /**
     * Obtain all productions ordered by date desc
     * @return List of transactions
     */
    List<Production> findAllByOrderByDateDesc();
}
