package cn.konngo.entity;

import java.io.Serializable;

/**
 *  工作日志
 */
public class WorklogEntity implements Serializable{

        //编号
        private int id;
        //标题
        private String name;
        //内容
        private String content;
        //用户
        private int userid;
        //封面
        private String avatar;
        // 标签
        private int labels;

        public int getLabels() {
            return labels;
        }

        public void setLabels(int labels) {
            this.labels = labels;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }


        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }


        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }


}
