package com.kevvlvl.financeapi.repository;

import com.kevvlvl.financeapi.entity.HistoryStock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HistoryRepository extends JpaRepository<HistoryStock, Integer> {

    List<HistoryStock> findBySymbolOrderByCreatedOnDesc(String symbol);
}
