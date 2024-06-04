package org.gbhu.Serialization;

import com.fasterxml.jackson.annotation.JsonValue;

public enum JsonValueEnum {
    TYPE1(1, "Type A"), TYPE2(2, "Type 2");

    private Integer id;
    private String name;

    JsonValueEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }
}
