package com.kwh.utils;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kwh.exception.BizRuntimeException;

public abstract class JsonUtils {

    private static final ObjectMapper om = new ObjectMapper();

    public static String parseJSON(Object obj) {
        try {
            return om.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            throw new BizRuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    public static <T> T parseObject(String str) {
        try {
            return (T) om.readValue(str, Object.class);
        } catch (IOException e) {
            throw new BizRuntimeException(e);
        }
    }

}
