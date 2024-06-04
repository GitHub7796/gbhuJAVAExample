package org.gbhu.Serialization;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"name","id"})//自定义序列化后的顺序
//@JsonPropertyOrder(alphabetic = true)//按照字典排序
public class JsonPropertyOrderBean {
    public int id;
    public String name;

    public JsonPropertyOrderBean(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
