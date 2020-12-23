package com.kevvlvl.financeapi.deserializer;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevvlvl.financeapi.dto.StockDto;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;

@Slf4j
public class StockDeserializer implements Deserializer<StockDto> {

    @Override
    public StockDto deserialize(String s, byte[] bytes) {

        ObjectMapper mapper = new ObjectMapper();
        StockDto stock =  null;

        try {
            stock = mapper.readValue(bytes, StockDto.class);
        } catch (JsonParseException | JsonMappingException e) {
            log.error("JSON Exception when trying to deserialize", e);
            e.printStackTrace();
        } catch (IOException e) {
            log.error("IOException when trying to deserialize", e);
            e.printStackTrace();
        }

        return stock;
    }
}
