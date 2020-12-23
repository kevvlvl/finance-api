package com.kevvlvl.financeapi.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "history_stocks", schema = "stocks_app")
public class HistoryStock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private int id;

    @Column(columnDefinition = "VARCHAR(100)")
    @Getter
    @Setter
    private String symbol;

    @Column(name = "stock_value", columnDefinition = "DECIMAL(10,6) DEFAULT 0", nullable = false)
    @Getter
    @Setter
    private BigDecimal stockValue;

    @Column(name = "created_on", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", nullable = false, insertable = false, updatable = false)
    @Getter
    private LocalDateTime createdOn;
}
