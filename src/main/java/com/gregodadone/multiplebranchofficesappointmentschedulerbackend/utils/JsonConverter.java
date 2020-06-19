package com.gregodadone.multiplebranchofficesappointmentschedulerbackend.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.stereotype.Component;

@Component
public class JsonConverter {

    private final ObjectMapper mapper;

    public JsonConverter(ObjectMapper mapper) {
        this.mapper = createMapper();
    }

    public Object fromJson(String jsonString) {
        Object o = null;
        try {
            o = mapper.readValue(jsonString, Object.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return o;
    }

    public String toJson(Object o) {
        String jsonString = null;
        try {
            jsonString = mapper.writeValueAsString(o);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return jsonString;
    }

    private ObjectMapper createMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        return mapper;
    }
}
