package org.gbhu.Deserialization;


import com.fasterxml.jackson.databind.InjectableValues;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.io.IOException;
import java.text.SimpleDateFormat;

import static org.junit.Assert.assertEquals;

public class Main {
    @Test
    public void testJsonAnySetter()
            throws IOException {
        String json
                = "{\"name\":\"My bean\",\"attr2\":\"val2\",\"attr1\":\"val1\"}";
        JsonAnySetterBean bean = new ObjectMapper()
                .readerFor(JsonAnySetterBean.class)
                .readValue(json);
        System.out.println(bean);
        //{name='My bean', properties={attr2=val2, attr1=val1}}
    }
    @Test
    public void testJsonSetter()
            throws IOException {
        String json = "{\"id\":1,\"name\":\"My bean\"}";
        JsonSetterBean bean = new ObjectMapper()
                .readerFor(JsonSetterBean.class)
                .readValue(json);
        System.out.println(bean);
        //JsonSetterBean{id=1, name='My bean'}
    }

    @Test
    public void testJsonCreator()
            throws IOException {
        String json = "{\"id\":1,\"theName\":\"My bean\"}";
        JsonCreatorBean bean = new ObjectMapper()
                .readerFor(JsonCreatorBean.class)
                .readValue(json);
        System.out.println(bean);
        //JsonCreatorBean{id=1, name='My bean'}
    }
    @Test
    public void testJacksonInject()
            throws IOException {
        String json = "{\"name\":\"My bean\"}";
        InjectableValues inject = new InjectableValues.Std()
                .addValue(int.class, 1);
        JacksonInjectBean bean = new ObjectMapper().reader(inject)
                .forType(JacksonInjectBean.class)
                .readValue(json);
        System.out.println(bean);
        //JacksonInjectBean{id=1, name='My bean'}
    }
    @Test
    public void whenDeserializingUsingJsonDeserialize_thenCorrect()
            throws IOException {
        String json
                = "{\"name\":\"party\",\"eventDate\":\"20-12-2014 02:30:00\"}";
        SimpleDateFormat df
                = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
        JsonDeserializeBean event = new ObjectMapper()
                .readerFor(JsonDeserializeBean.class)
                .readValue(json);
        assertEquals(
                "20-12-2014 02:30:00", df.format(event.eventDate));
    }

    @Test
    public void testJsonAlias() throws IOException {
//        String json = "{\"fName\": \"John\", \"lastName\": \"Green\"}";
        String json = "{\"f_name\": \"John\", \"lastName\": \"Green\"}";
        JsonAliasBean aliasBean = new ObjectMapper().readerFor(JsonAliasBean.class).readValue(json);
        System.out.println(aliasBean);
        //JsonAliasBean{firstName='John', lastName='Green'}
    }
}