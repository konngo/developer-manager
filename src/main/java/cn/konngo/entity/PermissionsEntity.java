package cn.konngo.entity;

import java.io.Serializable;

/**
 *  权限
 */
public class PermissionsEntity implements Serializable{

        //编号
        private int id;
        //权限名称
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
