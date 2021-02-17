package cn.konngo.dao;


import cn.konngo.entity.SkillsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
  *  技能持久层 数据库操作
  */
@Mapper
public interface SkillsDao {

    /**
    *  查询所有技能
    */
    List<SkillsEntity> list();

    /**
    * 根据id查询技能
    */
    SkillsEntity select(int id);

    /**
    * 删除技能
    */
    int delete(int id);

    /**
    * 更新技能
    */
    int update(SkillsEntity skillsEntity);

    /**
    * 插入技能
    */
    int insert(SkillsEntity skillsEntity);

    List listByUser(int id);
}