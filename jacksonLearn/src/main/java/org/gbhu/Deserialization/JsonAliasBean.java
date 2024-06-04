package org.gbhu.Deserialization;

import com.fasterxml.jackson.annotation.JsonAlias;

public class JsonAliasBean {
    @JsonAlias({ "fName", "f_name" })
    private String firstName;
    private String lastName;

    @Override
    public String toString() {
        return "JsonAliasBean{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
