package com.aitao.util;

import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;


/**
 * Created by caowei on 16/4/26.
 */
public class ObjectMapperUtil {
    static ObjectMapper mapper = new ObjectMapper();
    static {

        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        mapper.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,false);

    }

    public static <T> T readValue(String content, Class<T> valueType) {

        try {
            return mapper.readValue(content, valueType);
        } catch (Exception e) {
            return null;
        }
    }


    public static String writeValueAsString(Object value) {
        try {
            return mapper.writeValueAsString(value);
        } catch (Exception e) {
            return null;
        }
    }

}
