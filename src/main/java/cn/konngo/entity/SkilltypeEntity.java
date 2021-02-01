package cn.konngo.entity;

import java.io.Serializable;

/**
 *  技能分类
 */
public class SkilltypeEntity implements Serializable{

        //编号
        private int id;
        //技能分类名称
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
