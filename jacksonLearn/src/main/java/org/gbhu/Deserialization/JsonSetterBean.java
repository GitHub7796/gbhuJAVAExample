package org.gbhu.Deserialization;

import com.fasterxml.jackson.annotation.JsonSetter;

public class JsonSetterBean {
    public int id;
    private String name;

    @JsonSetter("name")
    public void setTheName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "JsonSetterBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
