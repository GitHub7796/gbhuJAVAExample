package org.gbhu.customJacksonAnnotation;


import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.gbhu.Deserialization.*;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class Main {
    @Test
    public void testCustomJacksonAnnotation() throws IOException{
        BeanWithCustomAnnotation bean
                = new BeanWithCustomAnnotation(1, "My bean", null);
        String result = new ObjectMapper().writeValueAsString(bean);
        System.out.println(result);
        /**
         * {"name":"My bean","id":1}
         */
    }
}