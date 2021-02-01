package cn.konngo.service;

import cn.konngo.dao.WorklogDao;
import cn.konngo.entity.WorklogEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 工作日志 业务层
public class WorklogService {
    @Autowired
    WorklogDao worklogDao;

    // 查询所有工作日志
    public List<WorklogEntity> list(){
        return worklogDao.list();
    }

    // 根据id查询工作日志
    public WorklogEntity select(int id){return worklogDao.select(id);}

    // 删除工作日志
    public int delete (int id){return worklogDao.delete(id);}

    // 添加工作日志
    public int insert (WorklogEntity worklogEntity){return worklogDao.insert(worklogEntity);}

    // 更新工作日志
    public int update (WorklogEntity worklogEntity){ return worklogDao.update(worklogEntity);}

}
