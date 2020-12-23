package com.kevvlvl.financeapi.handler;

import com.kevvlvl.financeapi.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Component
public class HistoryStockHandler {

    private final FinanceService service;

    @Autowired
    public HistoryStockHandler(FinanceService service) {
        this.service = service;
    }

    public Mono<ServerResponse> history(ServerRequest request) {

        Optional<String> stockName = request.queryParam("stockName");

        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromValue(service.getHistory(stockName.orElse(""))));
    }
}
