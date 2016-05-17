package com.sou.common.util.jackson.serialize;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.SerializerProvider;

import com.sou.common.util.jackson.JackJsonUtil;

public class JackJsonIntegerListFormat extends JsonSerializer<List<Integer>> {

    @Override
    public void serialize(List<Integer> value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
            JsonProcessingException {
        String formatValue = "";
        if (value != null) {
            Map<String, Integer> map = new HashMap<String, Integer>(0);
            int len = value.size();
            for (int i = 0; i < len; i++) {
                map.put(String.valueOf(i).toString(), value.get(i));
            }
            formatValue = JackJsonUtil.toJson(map);
        }
        jgen.writeString(formatValue);
    }

}
