package cn.konngo.entity;

import java.io.Serializable;

/**
 *  用户技能
 */
public class UserskillsEntity implements Serializable{

        //编号
        private int id;
        //用户编号
        private int userid;
        //用户编号
        private int skillid;


        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public int getUserid() {
            return userid;
        }

        public void setUserid(int userid) {
            this.userid = userid;
        }


        public int getSkillid() {
            return skillid;
        }

        public void setSkillid(int skillid) {
            this.skillid = skillid;
        }


}
