package com.xm.core.utility;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;

public class JsonParser {

    private static ObjectMapper mapper = new ObjectMapper();
    @SneakyThrows
    public static <T> T fromJsonViaJackson(String json, Class<T> type) {
        return mapper.readValue(json, type);
    }
}
