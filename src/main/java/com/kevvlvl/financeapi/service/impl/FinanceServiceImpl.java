package com.kevvlvl.financeapi.service.impl;

import com.kevvlvl.financeapi.service.FinanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class FinanceServiceImpl implements FinanceService {

    private static final String TOPIC_STOCKS = "stocks";

    @KafkaListener(topics = TOPIC_STOCKS, groupId = "stock_gid")
    @Override
    public void consumeStockValue(Float value) {
        log.info("Stock value received: {}", value);
    }
}
