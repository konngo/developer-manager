package cn.konngo.entity;

import java.io.Serializable;

/**
 *  技能
 */
public class SkillsEntity implements Serializable{

        //编号
        private int id;
        //技能分类
        private int type;
        //技能名称
        private String name;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


}
