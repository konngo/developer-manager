package cn.konngo.entity;

import java.io.Serializable;

/**
 *  标签
 */
public class LabelsEntity implements Serializable{

        //编号
        private int id;
        //标签名称
        private String name;


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


}
