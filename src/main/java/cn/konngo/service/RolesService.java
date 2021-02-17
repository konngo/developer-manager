package cn.konngo.service;

import cn.konngo.dao.RolesDao;
import cn.konngo.entity.RolesEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 角色 业务层
public class RolesService {
    @Autowired
    RolesDao rolesDao;

    // 查询所有角色
    public List<RolesEntity> list(){
        return rolesDao.list();
    }

    // 根据id查询角色
    public RolesEntity select(int id){return rolesDao.select(id);}

    // 删除角色
    public int delete (int id){return rolesDao.delete(id);}

    // 添加角色
    public int insert (RolesEntity rolesEntity){return rolesDao.insert(rolesEntity);}

    // 更新角色
    public int update (RolesEntity rolesEntity){ return rolesDao.update(rolesEntity);}

    // 根据当前用户查询
    public RolesEntity selectByUser(int id) {
        return rolesDao.selectByUser(id);
    }

    public void addUserRole(int id, String type) {
         rolesDao.addUserRole(id, Integer.parseInt(type));
    }
}
