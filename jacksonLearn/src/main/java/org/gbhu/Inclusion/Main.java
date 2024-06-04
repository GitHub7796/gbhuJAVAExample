package org.gbhu.Inclusion;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.gbhu.Serialization.*;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    @Test
    public void testJsonIgnoreProperties()
            throws JsonProcessingException {
        JsonIgnorePropertiesBean bean = new JsonIgnorePropertiesBean(1, "My bean");
        String result = new ObjectMapper()
                .writeValueAsString(bean);
        System.out.println(result);
        /**
         * {"name":"My bean"}
         */
    }
    @Test
    public void testJsonIgnoreBean()
            throws JsonProcessingException {
        JsonIgnoreBean bean = new JsonIgnoreBean(1, "My bean");
        String result = new ObjectMapper()
                .writeValueAsString(bean);
        System.out.println(result);
        //{"name":"My bean"}
    }
    @Test
    public void whenSerializingUsingJsonIgnoreType_thenCorrect()
            throws JsonProcessingException, ParseException {
        JsonIgnoreTypeBean.Name name = new JsonIgnoreTypeBean.Name("John", "Doe");
        JsonIgnoreTypeBean.Name name1 = new JsonIgnoreTypeBean.Name("hah", "kak");
        JsonIgnoreTypeBean user = new JsonIgnoreTypeBean(1, name,name1);

        String result = new ObjectMapper()
                .writeValueAsString(user);
        System.out.println(result);
        //{"id":1}
    }
    @Test
    public void testJsonInclude()
            throws JsonProcessingException {

        JsonIncludeBean bean = new JsonIncludeBean(1, null);

        String result = new ObjectMapper()
                .writeValueAsString(bean);
        System.out.println(result);
        //{"id":1} 空数据不会被序列化
    }
    @Test
    public void testJsonAutoDetect()
            throws JsonProcessingException {

        JsonAutoDetectBean bean = new JsonAutoDetectBean(1, "My bean");
        String result = new ObjectMapper()
                .writeValueAsString(bean);
        System.out.println(result);
        //{"id":1,"name":"My bean"}
    }
}