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


}
