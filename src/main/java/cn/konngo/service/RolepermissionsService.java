package cn.konngo.service;

import cn.konngo.dao.RolepermissionsDao;
import cn.konngo.entity.RolepermissionsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 角色权限 业务层
public class RolepermissionsService {
    @Autowired
    RolepermissionsDao rolepermissionsDao;

    // 查询所有角色权限
    public List<RolepermissionsEntity> list(){
        return rolepermissionsDao.list();
    }

    // 根据id查询角色权限
    public RolepermissionsEntity select(int id){return rolepermissionsDao.select(id);}

    // 删除角色权限
    public int delete (int id){return rolepermissionsDao.delete(id);}

    // 添加角色权限
    public int insert (RolepermissionsEntity rolepermissionsEntity){return rolepermissionsDao.insert(rolepermissionsEntity);}

    // 更新角色权限
    public int update (RolepermissionsEntity rolepermissionsEntity){ return rolepermissionsDao.update(rolepermissionsEntity);}

}
