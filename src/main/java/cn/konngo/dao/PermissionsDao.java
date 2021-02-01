package cn.konngo.dao;


import cn.konngo.entity.PermissionsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
  *  权限持久层 数据库操作
  */
@Mapper
public interface PermissionsDao {

    /**
    *  查询所有权限
    */
    List<PermissionsEntity> list();

    /**
    * 根据id查询权限
    */
    PermissionsEntity select(int id);

    /**
    * 删除权限
    */
    int delete(int id);

    /**
    * 更新权限
    */
    int update(PermissionsEntity permissionsEntity);

    /**
    * 插入权限
    */
    int insert(PermissionsEntity permissionsEntity);

    // 根据角色获取权限
    List<PermissionsEntity> listByRoles(int id);
}