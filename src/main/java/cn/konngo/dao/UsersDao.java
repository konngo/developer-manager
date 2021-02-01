package cn.konngo.dao;


import cn.konngo.entity.UsersEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
  *  用户持久层 数据库操作
  */
@Mapper
public interface UsersDao {

    /**
    *  查询所有用户
    */
    List<UsersEntity> list();

    /**
    * 根据id查询用户
    */
    UsersEntity select(int id);

    /**
    * 删除用户
    */
    int delete(int id);

    /**
    * 更新用户
    */
    int update(UsersEntity usersEntity);

    /**
    * 插入用户
    */
    int insert(UsersEntity usersEntity);

    UsersEntity getByUserName(String name);
}