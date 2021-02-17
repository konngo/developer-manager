package cn.konngo.entity;

import java.io.Serializable;

/**
 *  角色权限
 */
public class RolepermissionsEntity implements Serializable{

        //编号
        private int id;
        //角色编号
        private int roleid;
        //权限编号
        private int perid;

    public RolepermissionsEntity() {
    }

    public RolepermissionsEntity(int roleid, int perid) {
        this.roleid = roleid;
        this.perid = perid;
    }

    public RolepermissionsEntity(int id, int roleid, int perid) {
        this.id = id;
        this.roleid = roleid;
        this.perid = perid;
    }

    public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public int getRoleid() {
            return roleid;
        }

        public void setRoleid(int roleid) {
            this.roleid = roleid;
        }


        public int getPerid() {
            return perid;
        }

        public void setPerid(int perid) {
            this.perid = perid;
        }


}
