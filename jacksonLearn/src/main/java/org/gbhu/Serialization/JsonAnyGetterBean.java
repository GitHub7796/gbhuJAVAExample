package org.gbhu.Serialization;

import com.fasterxml.jackson.annotation.JsonAnyGetter;

import java.util.HashMap;
import java.util.Map;

public class JsonAnyGetterBean {
    private String name;
    private Map<String, String> properties;

    @JsonAnyGetter
    public Map<String, String> getProperties() {
        return properties;
    }

    public JsonAnyGetterBean(String name) {
        properties = new HashMap<String, String>();
        this.name = name;
    }

    public void add(String attr1, String val1) {
        this.properties.put(attr1, val1);
    }
}
