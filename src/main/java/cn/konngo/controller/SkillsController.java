package cn.konngo.controller;

import cn.konngo.entity.SkillsEntity;
import cn.konngo.service.SkillsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/skills")
// 技能 控制层
public class SkillsController {
    @Autowired
    SkillsService skillsService;


    @RequestMapping("list")
    @ResponseBody
    // 返回所有技能
    public Map list(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=skillsService.list();
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("search")
    @ResponseBody
    // 查询指定技能
    public Map search(int id){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        SkillsEntity skillsEntity=skillsService.select(id);
        map.put("entity",skillsEntity);
        return map;
    }


    @RequestMapping("delete")
    @ResponseBody
    // 根据id删除技能
    public HashMap delete(int id){
        HashMap map=new HashMap();
        int count=skillsService.delete(id);
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }

    @RequestMapping("addOrUpdate")
    @ResponseBody
    // 添加或者修改技能
    public HashMap saveOrUpdate(SkillsEntity skillsEntity){
        HashMap map=new HashMap();

        int count=0;
        // 根据id进行判断，如果id为空或者0进行添加操作，否则进行修改
        if ((""+skillsEntity.getId()).equals("")||skillsEntity.getId()==0){
            count=skillsService.insert(skillsEntity);
        }else {
            count=skillsService.update(skillsEntity);
        }
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }


    @RequestMapping("page")
    public String page(){
         return "skillslist";
    }
}
