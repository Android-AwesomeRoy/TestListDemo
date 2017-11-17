package com.example.kcb;

import java.util.List;

/**
 * Created by Roy12 on 2017/11/16.
 */

public class Kcb {

    /**
     * code : 200
     * msg : 访问成功
     * items : [{"week":"周一","courses":[{"start":"08:10:00","end":"08:50:00","keshi":"第1节","subject":"数学","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"09:00:00","end":"09:40:00","keshi":"第2节","subject":"语文","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"10:10:00","end":"10:50:00","keshi":"第3节","subject":"英语","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"11:00:00","end":"11:40:00","keshi":"第4节","subject":"美术","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"14:20:00","end":"15:00:00","keshi":"第5节","subject":"综合实践","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"15:10:00","end":"15:50:00","keshi":"第6节","subject":"信息技术","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"16:10:00","end":"16:50:00","keshi":"第7节","subject":"阳光体育","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"}]},{"week":"周三","courses":[{"start":"08:10:00","end":"08:50:00","keshi":"第1节","subject":"数学","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"09:00:00","end":"09:40:00","keshi":"第2节","subject":"语文","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"10:10:00","end":"10:50:00","keshi":"第3节","subject":"美术","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"11:00:00","end":"11:40:00","keshi":"第4节","subject":"品德与社会","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"14:20:00","end":"15:00:00","keshi":"第5节","subject":"英语","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"15:10:00","end":"15:50:00","keshi":"第6节","subject":"体育与健康","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"16:10:00","end":"16:50:00","keshi":"第7节","subject":"自主活动","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"}]},{"week":"周二","courses":[{"start":"08:10:00","end":"08:50:00","keshi":"第1节","subject":"语文","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"09:00:00","end":"09:40:00","keshi":"第2节","subject":"数学","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"10:10:00","end":"10:50:00","keshi":"第3节","subject":"品德与社会","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"11:00:00","end":"11:40:00","keshi":"第4节","subject":"体育与健康","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"14:20:00","end":"15:00:00","keshi":"第5节","subject":"音乐","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"15:10:00","end":"15:50:00","keshi":"第6节","subject":"科学","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"16:10:00","end":"16:50:00","keshi":"第7节","subject":"自主活动","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"}]},{"week":"周五","courses":[{"start":"08:10:00","end":"08:50:00","keshi":"第1节","subject":"语文","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"09:00:00","end":"09:40:00","keshi":"第2节","subject":"数学","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"10:10:00","end":"10:50:00","keshi":"第3节","subject":"体育与健康","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"11:00:00","end":"11:40:00","keshi":"第4节","subject":"综合实践","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"14:20:00","end":"15:00:00","keshi":"第5节","subject":"地校","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"15:10:00","end":"15:50:00","keshi":"第6节","subject":"地校","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"16:10:00","end":"16:50:00","keshi":"第7节","subject":"自主活动","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"}]},{"week":"周四","courses":[{"start":"08:10:00","end":"08:50:00","keshi":"第1节","subject":"英语","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"09:00:00","end":"09:40:00","keshi":"第2节","subject":"数学","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"10:10:00","end":"10:50:00","keshi":"第3节","subject":"科学","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"11:00:00","end":"11:40:00","keshi":"第4节","subject":"音乐","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"14:20:00","end":"15:00:00","keshi":"第5节","subject":"语文","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"15:10:00","end":"15:50:00","keshi":"第6节","subject":"语文","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"16:10:00","end":"16:50:00","keshi":"第7节","subject":"阳光体育","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"}]}]
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
         * week : 周一
         * courses : [{"start":"08:10:00","end":"08:50:00","keshi":"第1节","subject":"数学","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"09:00:00","end":"09:40:00","keshi":"第2节","subject":"语文","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"10:10:00","end":"10:50:00","keshi":"第3节","subject":"英语","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"11:00:00","end":"11:40:00","keshi":"第4节","subject":"美术","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"14:20:00","end":"15:00:00","keshi":"第5节","subject":"综合实践","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"15:10:00","end":"15:50:00","keshi":"第6节","subject":"信息技术","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"},{"start":"16:10:00","end":"16:50:00","keshi":"第7节","subject":"阳光体育","weeks":"全","teacher_name":"刘老师","image_name":"t01e5e5719f396c4faa.png","image_path":"http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png"}]
         */

        private String week;
        private List<CoursesBean> courses;

        public String getWeek() {
            return week;
        }

        public void setWeek(String week) {
            this.week = week;
        }

        public List<CoursesBean> getCourses() {
            return courses;
        }

        public void setCourses(List<CoursesBean> courses) {
            this.courses = courses;
        }

        public static class CoursesBean {
            /**
             * start : 08:10:00
             * end : 08:50:00
             * keshi : 第1节
             * subject : 数学
             * weeks : 全
             * teacher_name : 刘老师
             * image_name : t01e5e5719f396c4faa.png
             * image_path : http://59.110.237.176:8081/obpm/uploads/teacher/2017/5c849a9a-4008-4c18-b025-c0255d859d2a.png
             */

            private String start;
            private String end;
            private String keshi;
            private String subject;
            private String weeks;
            private String teacher_name;
            private String image_name;
            private String image_path;

            public String getStart() {
                return start;
            }

            public void setStart(String start) {
                this.start = start;
            }

            public String getEnd() {
                return end;
            }

            public void setEnd(String end) {
                this.end = end;
            }

            public String getKeshi() {
                return keshi;
            }

            public void setKeshi(String keshi) {
                this.keshi = keshi;
            }

            public String getSubject() {
                return subject;
            }

            public void setSubject(String subject) {
                this.subject = subject;
            }

            public String getWeeks() {
                return weeks;
            }

            public void setWeeks(String weeks) {
                this.weeks = weeks;
            }

            public String getTeacher_name() {
                return teacher_name;
            }

            public void setTeacher_name(String teacher_name) {
                this.teacher_name = teacher_name;
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
        }
    }
}
