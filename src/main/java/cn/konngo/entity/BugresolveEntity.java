package cn.konngo.entity;

import java.io.Serializable;

/**
 *  BUG解决方案
 */
public class BugresolveEntity implements Serializable{

        //编号
        private int id;
        //bug名称
        private String name;
        //内容
        private String content;
        //封面
        private String avatar;
        //用户编号
        private int userid;
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


        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }


        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }


}
