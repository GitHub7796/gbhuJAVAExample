package org.gbhu.Inclusion;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class JsonIncludeBean {
    public int id;
    public String name;

    public JsonIncludeBean(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
