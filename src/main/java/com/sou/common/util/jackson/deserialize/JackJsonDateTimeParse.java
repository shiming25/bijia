package com.sou.common.util.jackson.deserialize;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JackJsonDateTimeParse extends JsonDeserializer<Date> {
    private static final Logger LOG = LoggerFactory.getLogger(JackJsonDateTimeParse.class);

    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = jp.getText();
        if(date==null||date.trim().length()==0){
        	return null;
        }
        try {
            return format.parse(date);
        } catch (Exception e) {
            LOG.error("日期解析出错", e);
        }
        return null;
    }

}
