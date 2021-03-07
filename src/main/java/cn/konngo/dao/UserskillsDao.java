package cn.konngo.dao;


import cn.konngo.entity.UserskillsEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
  *  用户技能持久层 数据库操作
  */
@Mapper
public interface UserskillsDao {

    /**
    *  查询所有用户技能
    */
    List<UserskillsEntity> list();

    /**
    * 根据id查询用户技能
    */
    UserskillsEntity select(int id);

    /**
    * 删除用户技能
    */
    int delete(int id);

    /**
    * 更新用户技能
    */
    int update(UserskillsEntity userskillsEntity);

    /**
    * 插入用户技能
    */
    int insert(UserskillsEntity userskillsEntity);

    int deleteByuser(@Param("skillid") int skillid,@Param("userid") int userid);
}