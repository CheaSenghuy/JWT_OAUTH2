package com.example.spring_jwt_config.common.utils;


import com.example.spring_jwt_config.logging.AppLogManager;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.http.HttpMethod;

import java.util.Map;
import java.util.stream.Collectors;

public class ObjectUtils  {
    static private final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        mapper.setSerializationInclusion(JsonInclude.Include.ALWAYS);
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JavaTimeModule());

    }

    public static String writeValueAsString(Object value) {
        try {
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Convert POJO to Map
    public static String convertPojoToMap(Object pojo)
    {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.convertValue(pojo, new TypeReference<Map<String, Object>>() {});
        return map.entrySet().stream().map(x -> {
            return x.getKey() + "=" + x.getValue();
        }).collect(Collectors.joining("&"));

        // Convert Map to POJO
        // Foo anotherFoo = mapper.convertValue(map, Foo.class);
    }

    public static <T> T readValue(String str, TypeReference<T> tr) {
        try {
            return mapper.readValue(str, tr);
        } catch (Exception e) {
            AppLogManager.error(e);
        }

        return null;
    }

    public static String writerWithDefaultPrettyPrinter(Object value){
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(value);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return String.valueOf(value);
    }

    public static String writeValueAsSingleLineString(Object value){
        try {
            mapper.disable(SerializationFeature.INDENT_OUTPUT);
            return mapper.writeValueAsString(value);
        } catch (JsonProcessingException e) {
//            AppLogManager.error(e);
        }

        return String.valueOf(value);
    }

    public static StringBuilder logBeforeRequest (String url, HttpMethod httpMethod, Object request){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("\n[Request]\n")
                .append("[Url [ ").append(httpMethod)
                .append ( " " )
                .append(url).append("]\n")
                .append("[Body] [")
                .append(ObjectUtils.writeValueAsString(request))
                .append("]\n");
        return stringBuilder;
    }

    public static StringBuilder logAfterResponse (String url,HttpMethod httpMethod,Object request){

        StringBuilder sb = new StringBuilder();
        sb.append("\n[Response]\n")
                .append("[Url [ ").append(httpMethod)
                .append ( " " )
                .append(url).append("]\n")
                .append("[Body] [{")
                .append(ObjectUtils.writeValueAsString(request))
                .append("}\n");
        return sb;
    }
}
