package com.example.videodownloadtest;

import java.util.List;

/**
 * Created by Roy12 on 2017/10/16.
 */

public class VideoBean {

    private String code;
    private String msg;
    private List<ItemsBean> items;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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

        private String description;
        private String display_class;
        private String start_time;
        private String end_time;
        private String display_range;
        private boolean show_all;
        private List<VideoDescribeBean> video_describe;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDisplay_class() {
            return display_class;
        }

        public void setDisplay_class(String display_class) {
            this.display_class = display_class;
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getEnd_time() {
            return end_time;
        }

        public void setEnd_time(String end_time) {
            this.end_time = end_time;
        }

        public String getDisplay_range() {
            return display_range;
        }

        public void setDisplay_range(String display_range) {
            this.display_range = display_range;
        }

        public boolean isShow_all() {
            return show_all;
        }

        public void setShow_all(boolean show_all) {
            this.show_all = show_all;
        }

        public List<VideoDescribeBean> getVideo_describe() {
            return video_describe;
        }

        public void setVideo_describe(List<VideoDescribeBean> video_describe) {
            this.video_describe = video_describe;
        }

        public static class VideoDescribeBean {

            private int sort;
            private String task_id;
            private String video_path;
            private String video_name;
            private String path;

            public int getSort() {
                return sort;
            }

            public void setSort(int sort) {
                this.sort = sort;
            }

            public String getTask_id() {
                return task_id;
            }

            public void setTask_id(String task_id) {
                this.task_id = task_id;
            }

            public String getVideo_path() {
                return video_path;
            }

            public void setVideo_path(String video_path) {
                this.video_path = video_path;
            }

            public String getVideo_name() {
                return video_name;
            }

            public void setVideo_name(String video_name) {
                this.video_name = video_name;
            }

            public String getPath() {
                return path;
            }

            public void setPath(String path) {
                this.path = path;
            }
        }
    }
}
