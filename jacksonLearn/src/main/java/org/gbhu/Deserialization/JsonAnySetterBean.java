package org.gbhu.Deserialization;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class JsonAnySetterBean {
    private String name;
    private Map<String, String> properties;

    public JsonAnySetterBean() {
        this.properties = new HashMap<>();
    }

    @JsonAnySetter
    public void add(String key, String value) {
        properties.put(key, value);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JsonAnySetterBean{" +
                "name='" + name + '\'' +
                ", properties=" + properties +
                '}';
    }
}
