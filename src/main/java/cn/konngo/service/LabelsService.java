package cn.konngo.service;

import cn.konngo.dao.LabelsDao;
import cn.konngo.entity.LabelsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 标签 业务层
public class LabelsService {
    @Autowired
    LabelsDao labelsDao;

    // 查询所有标签
    public List<LabelsEntity> list(){
        return labelsDao.list();
    }

    // 根据id查询标签
    public LabelsEntity select(int id){return labelsDao.select(id);}

    // 删除标签
    public int delete (int id){return labelsDao.delete(id);}

    // 添加标签
    public int insert (LabelsEntity labelsEntity){return labelsDao.insert(labelsEntity);}

    // 更新标签
    public int update (LabelsEntity labelsEntity){ return labelsDao.update(labelsEntity);}

}
