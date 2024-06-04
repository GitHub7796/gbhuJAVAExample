package org.gbhu.Inclusion;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

public class JsonIgnoreTypeBean {
    public int id;
    public Name name;
    public Name name2;

    @JsonIgnoreType
    public static class Name {
        public String firstName;
        public String lastName;

        public Name(String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
    }

    public JsonIgnoreTypeBean(int id, Name name, Name name2) {
        this.id = id;
        this.name = name;
        this.name2 = name2;
    }
}
