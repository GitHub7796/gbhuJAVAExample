package org.gbhu.Serialization;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    @Test
    public void testJsonAnyGetter()
            throws JsonProcessingException {
        JsonAnyGetterBean bean = new JsonAnyGetterBean("My bean");
        bean.add("attr1", "val1");
        bean.add("attr2", "val2");
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
        /**
         * {
         * 	"name": "My bean",
         * 	"attr2": "val2",
         * 	"attr1": "val1"
         * }
         */
    }
    @Test
    public void testJsonGetter()
            throws JsonProcessingException {
        JsonGetterBean bean = new JsonGetterBean(1, "My bean");
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
        /**
         *{
         * 	"id": 1,
         * 	"name": "My bean"
         * }
         */
    }
    @Test
    public void testJsonPropertyOrder()
            throws JsonProcessingException {
        JsonPropertyOrderBean bean = new JsonPropertyOrderBean(1, "My bean");
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
        /**
         *{
         * 	"name": "My bean",
         * 	"id": 1
         * }
         */
    }
    @Test
    public void testJsonRawValueBean()
            throws JsonProcessingException {
        JsonRawValueBean bean = new JsonRawValueBean("My bean", "{\"attr\":false}");
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
        /**
         *{
         * 	"name": "My bean",
         * 	"json": {
         * 		"attr": false
         * 	    }
         * }
         */
    }
    @Test
    public void testJsonPropertyOrder1()
            throws JsonParseException, IOException {
        String enumAsString = new ObjectMapper()
                .writeValueAsString(JsonValueEnum.TYPE1);
        System.out.println(enumAsString);//"Type A"
    }
    @Test
    public void testJsonValue()
            throws JsonProcessingException {
        JsonRootNameBean user = new JsonRootNameBean(1, "John");
        ObjectMapper mapper = new ObjectMapper();
        // 只有当`WRAP_ROOT_VALUE`开启时，此注解才生效。
        mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
        String result = mapper.writeValueAsString(user);
        System.out.println(result);
        /**
         * {
         * 	"user": {
         * 		"id": 1,
         * 		"name": "John"
         * 	    }
         * }
         */
    }

    @Test
    public void testJsonSerialize()
            throws JsonProcessingException, ParseException {

        SimpleDateFormat df
                = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        String toParse = "20-12-2014 02:30:00";
        Date date = df.parse(toParse);
        JsonSerializeBean event = new JsonSerializeBean("party", date);
        String result = new ObjectMapper().writeValueAsString(event);
        System.out.println(result);
        /**
         * {
         * 	"name": "party",
         * 	"eventDate": "20-12-2014 02:30:00"
         * }
         */
    }
}