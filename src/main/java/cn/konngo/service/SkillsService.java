package cn.konngo.service;

import cn.konngo.dao.SkillsDao;
import cn.konngo.entity.SkillsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 技能 业务层
public class SkillsService {
    @Autowired
    SkillsDao skillsDao;

    // 查询所有技能
    public List<SkillsEntity> list(){
        return skillsDao.list();
    }

    // 根据id查询技能
    public SkillsEntity select(int id){return skillsDao.select(id);}

    // 删除技能
    public int delete (int id){return skillsDao.delete(id);}

    // 添加技能
    public int insert (SkillsEntity skillsEntity){return skillsDao.insert(skillsEntity);}

    // 更新技能
    public int update (SkillsEntity skillsEntity){ return skillsDao.update(skillsEntity);}

    public List listByUser(int id) {
        return  skillsDao.listByUser(id);
    }
}
