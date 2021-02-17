package cn.konngo.dao;


import cn.konngo.entity.RolepermissionsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
  *  角色权限持久层 数据库操作
  */
@Mapper
public interface RolepermissionsDao {

    /**
    *  查询所有角色权限
    */
    List<RolepermissionsEntity> list();

    /**
    * 根据id查询角色权限
    */
    RolepermissionsEntity select(int id);

    /**
    * 删除角色权限
    */
    int delete(int id);

    /**
    * 更新角色权限
    */
    int update(RolepermissionsEntity rolepermissionsEntity);

    /**
    * 插入角色权限
    */
    int insert(RolepermissionsEntity rolepermissionsEntity);

}