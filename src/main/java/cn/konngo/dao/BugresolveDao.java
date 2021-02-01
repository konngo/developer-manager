package cn.konngo.dao;


import cn.konngo.entity.BugresolveEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
  *  BUG解决方案持久层 数据库操作
  */
@Mapper
public interface BugresolveDao {

    /**
    *  查询所有BUG解决方案
    */
    List<BugresolveEntity> list();

    /**
    * 根据id查询BUG解决方案
    */
    BugresolveEntity select(int id);

    /**
    * 删除BUG解决方案
    */
    int delete(int id);

    /**
    * 更新BUG解决方案
    */
    int update(BugresolveEntity bugresolveEntity);

    /**
    * 插入BUG解决方案
    */
    int insert(BugresolveEntity bugresolveEntity);

}