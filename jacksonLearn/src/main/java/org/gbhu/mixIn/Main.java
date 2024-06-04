package org.gbhu.mixIn;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.gbhu.customJacksonAnnotation.BeanWithCustomAnnotation;
import org.junit.Test;

import java.io.IOException;

public class Main {
    @Test
    public void whenSerializingUsingMixInAnnotation_thenCorrect()
            throws JsonProcessingException {
        MixInBean item = new MixInBean(1, "book", null);

        String result = new ObjectMapper().writeValueAsString(item);
        System.out.println(result);
        /**
         *{"id":1,"itemName":"book","owner":null}
         */
        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(User.class, MyMixInForIgnoreType.class);

        result = mapper.writeValueAsString(item);
        System.out.println(result);
        /**
         * {"id":1,"itemName":"book"}
         */
    }
}