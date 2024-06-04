package org.gbhu.Inclusion;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class JsonAutoDetectBean {
    private int id;
    private String name;

    public JsonAutoDetectBean(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
