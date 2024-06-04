package org.gbhu.ObjectMapperLearn;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.gbhu.mixIn.MixInBean;
import org.gbhu.mixIn.MyMixInForIgnoreType;
import org.gbhu.mixIn.User;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    @Test
    public void testWriteValue()
            throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Car car = new Car("yellow", "renault");
        //写到文件
        objectMapper.writeValue(new File("target/car.json"), car);
        //转换为string
        String s = objectMapper.writeValueAsString(car);
        System.out.println(s);
        //{"color":"yellow","type":"renault"}
    }

    @Test
    public void testReadValue() throws IOException {
        String json = "{ \"color\" : \"Black\", \"type\" : \"BMW\" }";
        ObjectMapper objectMapper = new ObjectMapper();
        //从字符串读取
        Car car = objectMapper.readValue(json, Car.class);
        //从文件读取
        car = objectMapper.readValue(new File("src/test/resources/json_car.json"), Car.class);
        //从url读取
        car =objectMapper.readValue(new URL("file:src/test/resources/json_car.json"), Car.class);
    }

    @Test
    public void testJsonNode() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String json = "{ \"color\" : \"Black\", \"type\" : \"FIAT\" }";
        JsonNode jsonNode = objectMapper.readTree(json);
        String color = jsonNode.get("color").asText();
        System.out.println(color);
        // Output: color -> Black
    }
}