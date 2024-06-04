package org.gbhu.common;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.gbhu.Deserialization.*;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class Main {
    @Test
    public void testJsonView()
            throws JsonProcessingException {
        JsonViewBean item = new JsonViewBean(2, "book", "John","hello");

        String result = new ObjectMapper()
                .writerWithView(JsonViewBean.BaseView.class)
                .writeValueAsString(item);
        System.out.println(result);
        /**
         * {"id":2}
         */
        String result1 = new ObjectMapper()
                .writerWithView(JsonViewBean.View.class)
                .writeValueAsString(item);
        System.out.println(result1);
        /**
         * {"id":2,"itemName":"book","ownerName":"John"}
         */
        String result2 = new ObjectMapper()
                .writerWithView(JsonViewBean.View2.class)
                .writeValueAsString(item);
        System.out.println(result2);
        /**
         * {"id":2,"ownerName1":"hello"}
         */
    }

    @Test
    public void testJonsView2() throws JsonProcessingException {
        JsonViewBean2 item = new JsonViewBean2(2, "book", "John","hello");

        String result = new ObjectMapper()
                .writerWithView(ViewC.BaseView.class)
                .writeValueAsString(item);
        System.out.println(result);
        /**
         * {"id":2}
         */
        String result1 = new ObjectMapper()
                .writerWithView(ViewC.View.class)
                .writeValueAsString(item);
        System.out.println(result1);
        /**
         * {"id":2,"itemName":"book","ownerName":"John"}
         */
        String result2 = new ObjectMapper()
                .writerWithView(ViewC.View2.class)
                .writeValueAsString(item);
        System.out.println(result2);
        /**
         * {"id":2,"ownerName1":"hello"}
         */
    }

    /**
     * 禁用jackson注解
     */
    @Test
    public void diableJackson() throws JsonProcessingException {
        JsonViewBean item = new JsonViewBean(2, "book", "John","hello");
        ObjectMapper mapper = new ObjectMapper();
        //禁用jackson
        mapper.disable(MapperFeature.USE_ANNOTATIONS);
        String result = mapper.writerWithView(JsonViewBean.BaseView.class)
                .writeValueAsString(item);
        System.out.println(result);
        //{"id":2,"itemName":"book","ownerName":"John","ownerName1":"hello"}

    }
}