package org.dows.marketing.json.config.json.jackson.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.dows.marketing.json.config.converter.StringToDateUtil;

import java.io.IOException;
import java.util.Date;

/**
 * <p>
 *     Jackson Date序列化器
 * </p>
 * @author magang
 * @date 2018-11-08
 */
public class JacksonDateDeserializer extends JsonDeserializer<Date> {
    @Override
    public Date deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String date = jp.getText();
        return StringToDateUtil.convert(date);
    }

}
