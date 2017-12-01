package com.example.multiitem;

import java.util.List;

/**
 * Created by Roy12 on 2017/12/1.
 * 班级模式中, 左侧动态布局的数据模型
 */

public class DynamicBean {

    /**
     * code : 200
     * msg : 访问成功
     * items : [{"column_number":1,"class_id":"11e7-9f38-0b377c52-befc-cfffeac8f141","column_name":"校园新闻","column_id":"11e7-565a-e886c101-a262-815191aa084a","image_name":"_ONW_LK_P6RN]5VSH`1WA19.jpg","image_path":"http://192.168.3.13:8081/obpm/uploads/task/2017/e25410d2-9cc0-41bd-b2fe-753ec09735ec.jpg","column_type":2,"url":"http://192.168.3.13:8080/obpm/ClassOtherColumnDisplay?id=11e7-9f38-0b377c52-befc-cfffeac8f141&&columnid=11e7-565a-e886c101-a262-815191aa084a"},{"column_number":3,"class_id":"11e7-9f38-0b377c52-befc-cfffeac8f141","column_name":"锐捷产品","column_id":"11e7-b24d-673a01ed-b550-e35bb93ed9eb","image_name":null,"image_path":null,"column_type":1,"url":"http://192.168.3.13:8080/obpm/ClassOtherColumnDisplay?id=11e7-9f38-0b377c52-befc-cfffeac8f141&&columnid=11e7-b24d-673a01ed-b550-e35bb93ed9eb"},{"column_number":11,"class_id":"11e7-9f38-0b377c52-befc-cfffeac8f141","column_name":"学校荣誉","column_id":"11e7-565b-230ee2a0-a262-815191aa084a","image_name":null,"image_path":null,"column_type":2,"url":"http://192.168.3.13:8080/obpm/ClassOtherColumnDisplay?id=11e7-9f38-0b377c52-befc-cfffeac8f141&&columnid=11e7-565b-230ee2a0-a262-815191aa084a"},{"column_number":16,"class_id":"11e7-9f38-0b377c52-befc-cfffeac8f141","column_name":"校园动态","column_id":"11e7-7b13-a043c385-a4f3-414f6eee86db","image_name":null,"image_path":null,"column_type":1,"url":"http://192.168.3.13:8080/obpm/ClassOtherColumnDisplay?id=11e7-9f38-0b377c52-befc-cfffeac8f141&&columnid=11e7-7b13-a043c385-a4f3-414f6eee86db"}]
     */

    private int code;
    private String msg;
    private List<ItemsBean> items;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<ItemsBean> getItems() {
        return items;
    }

    public void setItems(List<ItemsBean> items) {
        this.items = items;
    }

    public static class ItemsBean {
        /**
         * column_number : 1
         * class_id : 11e7-9f38-0b377c52-befc-cfffeac8f141
         * column_name : 校园新闻
         * column_id : 11e7-565a-e886c101-a262-815191aa084a
         * image_name : _ONW_LK_P6RN]5VSH`1WA19.jpg
         * image_path : http://192.168.3.13:8081/obpm/uploads/task/2017/e25410d2-9cc0-41bd-b2fe-753ec09735ec.jpg
         * column_type : 2
         * url : http://192.168.3.13:8080/obpm/ClassOtherColumnDisplay?id=11e7-9f38-0b377c52-befc-cfffeac8f141&&columnid=11e7-565a-e886c101-a262-815191aa084a
         */

        private int column_number;
        private String class_id;
        private String column_name;
        private String column_id;
        private String image_name;
        private String image_path;
        private int column_type;
        private String url;

        public int getColumn_number() {
            return column_number;
        }

        public void setColumn_number(int column_number) {
            this.column_number = column_number;
        }

        public String getClass_id() {
            return class_id;
        }

        public void setClass_id(String class_id) {
            this.class_id = class_id;
        }

        public String getColumn_name() {
            return column_name;
        }

        public void setColumn_name(String column_name) {
            this.column_name = column_name;
        }

        public String getColumn_id() {
            return column_id;
        }

        public void setColumn_id(String column_id) {
            this.column_id = column_id;
        }

        public String getImage_name() {
            return image_name;
        }

        public void setImage_name(String image_name) {
            this.image_name = image_name;
        }

        public String getImage_path() {
            return image_path;
        }

        public void setImage_path(String image_path) {
            this.image_path = image_path;
        }

        public int getColumn_type() {
            return column_type;
        }

        public void setColumn_type(int column_type) {
            this.column_type = column_type;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
