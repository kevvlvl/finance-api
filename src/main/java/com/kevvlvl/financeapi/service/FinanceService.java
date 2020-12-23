package com.kevvlvl.financeapi.service;

import com.kevvlvl.financeapi.dto.StockDto;
import com.kevvlvl.financeapi.entity.HistoryStock;

import java.util.List;

public interface FinanceService {

    void consumeStockValue(StockDto message);
    List<StockDto> getHistory(String stockName);
}
