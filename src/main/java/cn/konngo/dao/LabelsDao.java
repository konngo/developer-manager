package cn.konngo.dao;


import cn.konngo.entity.LabelsEntity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
  *  标签持久层 数据库操作
  */
@Mapper
public interface LabelsDao {

    /**
    *  查询所有标签
    */
    List<LabelsEntity> list();

    /**
    * 根据id查询标签
    */
    LabelsEntity select(int id);

    /**
    * 删除标签
    */
    int delete(int id);

    /**
    * 更新标签
    */
    int update(LabelsEntity labelsEntity);

    /**
    * 插入标签
    */
    int insert(LabelsEntity labelsEntity);

}