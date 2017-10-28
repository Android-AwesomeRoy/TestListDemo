package com.example.roy12.testlistdemo;

import java.util.List;

/**
 * Created by Roy12 on 2017/10/14.
 */

public class ClassBean {
    public int code;
    public String msg;

    private List<ItemsBean> items;

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * isparent : true
         * classroomslist : null
         * id : 11e7-9eb3-7df9d967-befc-cfffeac8f141
         * item_NAME : 新校区
         * item_NUMBER : null
         * item_parentID :
         * item_QUALITY : null
         */

        private boolean isparent;
        private Object classroomslist;
        private String id;
        private String item_NAME;
        private Object item_NUMBER;
        private String item_parentID;
        private Object item_QUALITY;

        public boolean isIsparent() {
            return isparent;
        }

        public void setIsparent(boolean isparent) {
            this.isparent = isparent;
        }

        public Object getClassroomslist() {
            return classroomslist;
        }

        public void setClassroomslist(Object classroomslist) {
            this.classroomslist = classroomslist;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getItem_NAME() {
            return item_NAME;
        }

        public void setItem_NAME(String item_NAME) {
            this.item_NAME = item_NAME;
        }

        public Object getItem_NUMBER() {
            return item_NUMBER;
        }

        public void setItem_NUMBER(Object item_NUMBER) {
            this.item_NUMBER = item_NUMBER;
        }

        public String getItem_parentID() {
            return item_parentID;
        }

        public void setItem_parentID(String item_parentID) {
            this.item_parentID = item_parentID;
        }

        public Object getItem_QUALITY() {
            return item_QUALITY;
        }

        public void setItem_QUALITY(Object item_QUALITY) {
            this.item_QUALITY = item_QUALITY;
        }
    }
}
