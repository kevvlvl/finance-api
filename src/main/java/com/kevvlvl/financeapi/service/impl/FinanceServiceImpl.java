package com.kevvlvl.financeapi.service.impl;

import com.kevvlvl.financeapi.dto.StockDto;
import com.kevvlvl.financeapi.entity.HistoryStock;
import com.kevvlvl.financeapi.repository.HistoryRepository;
import com.kevvlvl.financeapi.service.FinanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class FinanceServiceImpl implements FinanceService {

    private static final String TOPIC_STOCKS = "stocks";
    private static final String GROUP_ID = "stock_gid";

    private final HistoryRepository historyRepository;

    @Autowired
    public FinanceServiceImpl(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
        log.info("Autowired complete");
    }

    @KafkaListener(topics = TOPIC_STOCKS, groupId = GROUP_ID)
    @Override
    public void consumeStockValue(StockDto stock) {

        log.info("Stock value received: {}", stock);

        HistoryStock stockEntity = new HistoryStock();
        stockEntity.setSymbol(stock.getName());
        stockEntity.setStockValue(stock.getValue());
        this.historyRepository.save(stockEntity);

        log.info("Stock saved in history_stocks DB");
    }

    @Override
    public List<StockDto> getHistory(String stockName) {

        List<HistoryStock> stocks = this.historyRepository.findBySymbolOrderByCreatedOnDesc(stockName);
        List<StockDto> stocksDto = stocks.stream()
                .map(s -> new StockDto(s.getSymbol(), s.getStockValue(), s.getCreatedOn()))
                .collect(Collectors.toList());

        return stocksDto;
    }
}
