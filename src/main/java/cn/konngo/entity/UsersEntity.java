package cn.konngo.entity;

import java.io.Serializable;
import java.util.List;

/**
 *  用户
 */
public class UsersEntity implements Serializable{

        //编号
        private int id;
        //用户名
        private String username;
        //昵称
        private String nickname;
        //密码
        private String password;
        //用户类型
        private String usertype;
        //性别
        private String gender;
        //地址
        private String address;
        //头像
        private String avatar;
        // 权限
        private List<RolesEntity> roles;


        public List<RolesEntity> getRoles() {
            return roles;
        }

        public void setRoles(List<RolesEntity> roles) {
            this.roles = roles;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }


        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }


        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }


        public String getUsertype() {
            return usertype;
        }

        public void setUsertype(String usertype) {
            this.usertype = usertype;
        }


        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }


        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }


        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

    @Override
    public String toString() {
        return "UsersEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", password='" + password + '\'' +
                ", usertype='" + usertype + '\'' +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", avatar='" + avatar + '\'' +
                ", roles=" + roles +
                '}';
    }
}
