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


}
