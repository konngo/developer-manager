package cn.konngo.service;

import cn.konngo.dao.SkilltypeDao;
import cn.konngo.entity.SkilltypeEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 技能分类 业务层
public class SkilltypeService {
    @Autowired
    SkilltypeDao skilltypeDao;

    // 查询所有技能分类
    public List<SkilltypeEntity> list(){
        return skilltypeDao.list();
    }

    // 根据id查询技能分类
    public SkilltypeEntity select(int id){return skilltypeDao.select(id);}

    // 删除技能分类
    public int delete (int id){return skilltypeDao.delete(id);}

    // 添加技能分类
    public int insert (SkilltypeEntity skilltypeEntity){return skilltypeDao.insert(skilltypeEntity);}

    // 更新技能分类
    public int update (SkilltypeEntity skilltypeEntity){ return skilltypeDao.update(skilltypeEntity);}

}
