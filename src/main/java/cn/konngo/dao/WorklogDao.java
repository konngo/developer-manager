package cn.konngo.dao;


import cn.konngo.entity.WorklogEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
  *  工作日志持久层 数据库操作
  */
@Mapper
public interface WorklogDao {

    /**
    *  查询所有工作日志
    */
    List<WorklogEntity> list();

    /**
    * 根据id查询工作日志
    */
    WorklogEntity select(int id);

    /**
    * 删除工作日志
    */
    int delete(int id);

    /**
    * 更新工作日志
    */
    int update(WorklogEntity worklogEntity);

    /**
    * 插入工作日志
    */
    int insert(WorklogEntity worklogEntity);

}