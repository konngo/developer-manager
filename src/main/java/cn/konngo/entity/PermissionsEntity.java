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
        //增删改查
        private String others;


    public PermissionsEntity() {
    }

    public PermissionsEntity(String name, String others) {
        this.name = name;
        this.others = others;
    }

    public PermissionsEntity(int id, String name, String others) {
        this.id = id;
        this.name = name;
        this.others = others;
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


        public String getOthers() {
            return others;
        }

        public void setOthers(String others) {
            this.others = others;
        }
}
