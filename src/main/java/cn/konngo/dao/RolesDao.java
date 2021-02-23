package cn.konngo.dao;


import cn.konngo.entity.RolesEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
  *  角色持久层 数据库操作
  */
@Mapper
public interface RolesDao {

    /**
    *  查询所有角色
    */
    List<RolesEntity> list();

    /**
    * 根据id查询角色
    */
    RolesEntity select(int id);

    /**
    * 删除角色
    */
    int delete(int id);

    /**
    * 更新角色
    */
    int update(RolesEntity rolesEntity);

    /**
    * 插入角色
    */
    int insert(RolesEntity rolesEntity);

    // 获取角色
    List<RolesEntity> listByUsers(int id);

    RolesEntity selectByUser(int id);

    void addUserRole(@Param("id") int id, @Param("type") int type);
}