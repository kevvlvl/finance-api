package com.kevvlvl.financeapi.route;

import com.kevvlvl.financeapi.handler.HistoryStockHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class HistoryStocksRoute {

    @Bean
    public RouterFunction<ServerResponse> route(HistoryStockHandler historyStockHandler) {

        return RouterFunctions
                .route(RequestPredicates.GET("/history").and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), historyStockHandler::history);
    }
}
