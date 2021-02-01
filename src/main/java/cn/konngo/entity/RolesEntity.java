package cn.konngo.entity;

import java.io.Serializable;
import java.util.List;

/**
 *  角色
 */
public class RolesEntity implements Serializable{

        //编号
        private int id;
        //角色名称
        private String name;
        // 权限
        private List<PermissionsEntity> permissions;

        public List<PermissionsEntity> getPermissions() {
            return permissions;
        }

        public void setPermissions(List<PermissionsEntity> permissions) {
            this.permissions = permissions;
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


}
