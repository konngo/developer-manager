package cn.konngo.service;

import cn.konngo.dao.PermissionsDao;
import cn.konngo.dao.RolesDao;
import cn.konngo.dao.UsersDao;
import cn.konngo.entity.PermissionsEntity;
import cn.konngo.entity.RolesEntity;
import cn.konngo.entity.UsersEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
// 用户 业务层
public class UsersService {
    @Autowired
    UsersDao usersDao;
    @Autowired
    RolesDao rolesDao;
    @Autowired
    PermissionsDao permissionsDao;

    // 查询所有用户
    public List<UsersEntity> list(){
        return usersDao.list();
    }

    // 根据id查询用户
    public UsersEntity select(int id){return usersDao.select(id);}

    // 删除用户
    public int delete (int id){return usersDao.delete(id);}

    // 添加用户
    public int insert (UsersEntity usersEntity){return usersDao.insert(usersEntity);}

    // 更新用户
    public int update (UsersEntity usersEntity){ return usersDao.update(usersEntity);}

    // 配置登录信息
    public UsersEntity login(String name) {
        // 1. 获取用户信息
        UsersEntity users=usersDao.getByUserName(name);
        // 2. 配置用户角色
        List<RolesEntity> roles=rolesDao.listByUsers(users.getId());
        List<RolesEntity> bak=new ArrayList<>();
        // 3. 给角色配置权限
        for (RolesEntity r: roles) {
            List<PermissionsEntity> list=permissionsDao.listByRoles(r.getId());
            r.setPermissions(list);
            bak.add(r);
        }
        users.setRoles(bak);
        return users;
    }
}
