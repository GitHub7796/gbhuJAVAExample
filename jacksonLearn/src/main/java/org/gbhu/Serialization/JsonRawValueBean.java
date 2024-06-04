package org.gbhu.Serialization;

import com.fasterxml.jackson.annotation.JsonRawValue;

public class JsonRawValueBean {
    public String name;

    @JsonRawValue
//    @JsonRawValue(value = false)//value 可以控制是否生效
    public String json;

    public JsonRawValueBean(String name, String json) {
        this.name = name;
        this.json = json;
    }
}
