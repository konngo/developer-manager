package cn.konngo.service;

import cn.konngo.dao.BugresolveDao;
import cn.konngo.entity.BugresolveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// BUG解决方案 业务层
public class BugresolveService {
    @Autowired
    BugresolveDao bugresolveDao;

    // 查询所有BUG解决方案
    public List<BugresolveEntity> list(){
        return bugresolveDao.list();
    }

    // 根据id查询BUG解决方案
    public BugresolveEntity select(int id){return bugresolveDao.select(id);}

    // 删除BUG解决方案
    public int delete (int id){return bugresolveDao.delete(id);}

    // 添加BUG解决方案
    public int insert (BugresolveEntity bugresolveEntity){return bugresolveDao.insert(bugresolveEntity);}

    // 更新BUG解决方案
    public int update (BugresolveEntity bugresolveEntity){ return bugresolveDao.update(bugresolveEntity);}

}
