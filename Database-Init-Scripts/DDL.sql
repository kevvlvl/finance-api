create schema "stocks_app";

create table stocks_app."history_stocks"
(
    id SERIAL,
    symbol VARCHAR(100),
    stock_value DECIMAL(10,6) NOT NULL DEFAULT 0,
    created_on TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT pk_history_stocks PRIMARY KEY (id)
);