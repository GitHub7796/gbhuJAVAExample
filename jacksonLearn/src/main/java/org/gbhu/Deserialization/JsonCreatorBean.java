package org.gbhu.Deserialization;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class JsonCreatorBean {
    public int id;
    public String name;

    @JsonCreator
    public JsonCreatorBean(
            @JsonProperty("id") int id,
            @JsonProperty("theName") String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "JsonCreatorBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
