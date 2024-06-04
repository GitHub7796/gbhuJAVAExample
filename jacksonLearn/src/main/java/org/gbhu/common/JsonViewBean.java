package org.gbhu.common;

import com.fasterxml.jackson.annotation.JsonView;

public class JsonViewBean {
    public interface BaseView{}
    public interface View extends BaseView{}
    public interface View2 extends BaseView{}

    @JsonView(BaseView.class)
    public int id;

    @JsonView(View.class)
    public String itemName;

    @JsonView(View.class)
    public String ownerName;

    @JsonView(View2.class)
    public String ownerName1;

    public JsonViewBean(int id, String itemName, String ownerName, String ownerName1) {
        this.id = id;
        this.itemName = itemName;
        this.ownerName = ownerName;
        this.ownerName1 = ownerName1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerName1() {
        return ownerName1;
    }

    public void setOwnerName1(String ownerName1) {
        this.ownerName1 = ownerName1;
    }
}
