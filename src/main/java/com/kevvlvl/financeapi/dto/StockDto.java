package com.kevvlvl.financeapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StockDto {

    private String name;
    private BigDecimal value;
    private LocalDateTime createdOn;
}

