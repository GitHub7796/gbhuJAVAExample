package org.gbhu.Serialization;

import com.fasterxml.jackson.annotation.JsonGetter;

public class JsonGetterBean {
    private int id;
    private String name;

    @JsonGetter("name")
    public String getTheName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public JsonGetterBean(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
