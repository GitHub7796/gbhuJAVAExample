package org.gbhu.Serialization;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.Date;

public class JsonSerializeBean {
    public String name;

    @JsonSerialize(using = CustomDateSerializer.class)
    public Date eventDate;

    public JsonSerializeBean(String name, Date eventDate) {
        this.name = name;
        this.eventDate = eventDate;
    }
}
