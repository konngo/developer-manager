package cn.konngo.service;

import cn.konngo.dao.PermissionsDao;
import cn.konngo.entity.PermissionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 权限 业务层
public class PermissionsService {
    @Autowired
    PermissionsDao permissionsDao;

    // 查询所有权限
    public List<PermissionsEntity> list(){
        return permissionsDao.list();
    }

    // 根据id查询权限
    public PermissionsEntity select(int id){return permissionsDao.select(id);}

    // 删除权限
    public int delete (int id){return permissionsDao.delete(id);}

    // 添加权限
    public int insert (PermissionsEntity permissionsEntity){return permissionsDao.insert(permissionsEntity);}

    // 更新权限
    public int update (PermissionsEntity permissionsEntity){ return permissionsDao.update(permissionsEntity);}

}
