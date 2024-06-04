package org.gbhu.Inclusion;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "id" })
public class JsonIgnorePropertiesBean {
    public int id;
    public String name;
    public JsonIgnorePropertiesBean(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
