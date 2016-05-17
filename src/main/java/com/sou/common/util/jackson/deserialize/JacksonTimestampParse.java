package com.sou.common.util.jackson.deserialize;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

/**
 * Jackson时间戳解析。<br>
 * 
 * @author
 */
public class JacksonTimestampParse extends JsonDeserializer<Timestamp> {

    @Override
    public Timestamp deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException,
            JsonProcessingException {
        Timestamp result = null;

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = jp.getText();

        if (date != null && date.trim().length() > 0) {
            try {
                result = new Timestamp(format.parse(date).getTime());
            } catch (ParseException e) {
                throw new IOException(e);
            }
        }

        return result;
    }

}
