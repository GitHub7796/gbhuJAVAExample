package org.gbhu.Deserialization;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.Date;

public class JsonDeserializeBean {
    public String name;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public Date eventDate;

    @Override
    public String toString() {
        return "JsonDeserializeBean{" +
                "name='" + name + '\'' +
                ", eventDate=" + eventDate +
                '}';
    }
}
