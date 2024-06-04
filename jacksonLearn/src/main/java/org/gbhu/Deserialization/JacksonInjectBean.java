package org.gbhu.Deserialization;

import com.fasterxml.jackson.annotation.JacksonInject;

public class JacksonInjectBean {
    @JacksonInject
    public int id;

    public String name;

    @Override
    public String toString() {
        return "JacksonInjectBean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
