package cn.konngo.service;

import cn.konngo.dao.UserskillsDao;
import cn.konngo.entity.UserskillsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 用户技能 业务层
public class UserskillsService {
    @Autowired
    UserskillsDao userskillsDao;

    // 查询所有用户技能
    public List<UserskillsEntity> list(){
        return userskillsDao.list();
    }

    // 根据id查询用户技能
    public UserskillsEntity select(int id){return userskillsDao.select(id);}

    // 删除用户技能
    public int delete (int id){return userskillsDao.delete(id);}

    // 添加用户技能
    public int insert (UserskillsEntity userskillsEntity){return userskillsDao.insert(userskillsEntity);}

    // 更新用户技能
    public int update (UserskillsEntity userskillsEntity){ return userskillsDao.update(userskillsEntity);}

    public int deleteByuser(int roleid, int userid) {
        return userskillsDao.deleteByuser(roleid,userid);
    }
}
