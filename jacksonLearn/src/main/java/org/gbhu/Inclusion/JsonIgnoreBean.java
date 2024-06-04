package org.gbhu.Inclusion;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class JsonIgnoreBean {
    @JsonIgnore
    public int id;
    public String name;

    public JsonIgnoreBean(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
