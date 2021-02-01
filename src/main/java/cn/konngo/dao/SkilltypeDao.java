package cn.konngo.dao;


import cn.konngo.entity.SkilltypeEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
  *  技能分类持久层 数据库操作
  */
@Mapper
public interface SkilltypeDao {

    /**
    *  查询所有技能分类
    */
    List<SkilltypeEntity> list();

    /**
    * 根据id查询技能分类
    */
    SkilltypeEntity select(int id);

    /**
    * 删除技能分类
    */
    int delete(int id);

    /**
    * 更新技能分类
    */
    int update(SkilltypeEntity skilltypeEntity);

    /**
    * 插入技能分类
    */
    int insert(SkilltypeEntity skilltypeEntity);

}