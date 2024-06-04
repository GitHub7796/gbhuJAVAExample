package org.gbhu.Serialization;

import com.fasterxml.jackson.annotation.JsonRootName;

@JsonRootName(value = "user")
public class JsonRootNameBean {
    public int id;
    public String name;
    public JsonRootNameBean(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
