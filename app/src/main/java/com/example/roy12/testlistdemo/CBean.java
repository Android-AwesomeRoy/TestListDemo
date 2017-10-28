package com.example.roy12.testlistdemo;

import java.util.List;

/**
 * Created by Roy12 on 2017/10/14.
 */

public class CBean {

    private int code;
    private String msg;
    private List<ItemsBean> items;


    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    /**
     * 校区层级
     */
    public static class ItemsBean {

        public boolean isParent; // 是否有子节点
        public String id;
        public String item_parentID;
        public String item_NAME;
        public Object item_QUALITY;
        public Object item_NUMBER;

        public boolean isParent() {
            return isParent;
        }

        public void setParent(boolean parent) {
            this.isParent = parent;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getItem_parentID() {
            return item_parentID;
        }

        public void setItem_parentID(String item_parentID) {
            this.item_parentID = item_parentID;
        }

        public String getItem_NAME() {
            return item_NAME;
        }

        public void setItem_NAME(String item_NAME) {
            this.item_NAME = item_NAME;
        }

        public Object getItem_QUALITY() {
            return item_QUALITY;
        }

        public void setItem_QUALITY(Object item_QUALITY) {
            this.item_QUALITY = item_QUALITY;
        }

        public Object getItem_NUMBER() {
            return item_NUMBER;
        }

        public void setItem_NUMBER(Object item_NUMBER) {
            this.item_NUMBER = item_NUMBER;
        }

    }
}
