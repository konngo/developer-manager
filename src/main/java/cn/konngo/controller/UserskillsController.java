package cn.konngo.controller;

import cn.konngo.entity.UsersEntity;
import cn.konngo.entity.UserskillsEntity;
import cn.konngo.service.SkillsService;
import cn.konngo.service.UsersService;
import cn.konngo.service.UserskillsService;
import org.apache.shiro.SecurityUtils;
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
@RequestMapping("/userskills")
// 用户技能 控制层
public class UserskillsController {
    @Autowired
    UserskillsService userskillsService;
    @Autowired
    SkillsService skillsService;

    @Autowired
    UsersService usersService;

    @RequestMapping("list")
    @ResponseBody
    // 返回所有用户技能
    public Map list(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=userskillsService.list();
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }


    @RequestMapping("nowuser")
    @ResponseBody
    // 返回当前用户技能
    public Map nowuser(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        UsersEntity usersEntity=usersService.login(username);
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=skillsService.listByUser(usersEntity.getId());
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("search")
    @ResponseBody
    // 查询指定用户技能
    public Map search(int id){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        UserskillsEntity userskillsEntity=userskillsService.select(id);
        map.put("entity",userskillsEntity);
        return map;
    }


    @RequestMapping("delete")
    @ResponseBody
    // 根据id删除用户技能
    public HashMap delete(int id){

        String username = (String) SecurityUtils.getSubject().getPrincipal();
        UsersEntity usersEntity=usersService.login(username);
        HashMap map=new HashMap();
        int count=userskillsService.deleteByuser(id,usersEntity.getId());
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }

    @RequestMapping("addOrUpdate")
    @ResponseBody
    // 添加或者修改用户技能
    public HashMap saveOrUpdate(UserskillsEntity userskillsEntity){
        HashMap map=new HashMap();

        int count=0;
        // 根据id进行判断，如果id为空或者0进行添加操作，否则进行修改
        if ((""+userskillsEntity.getId()).equals("")||userskillsEntity.getId()==0){
            String username = (String) SecurityUtils.getSubject().getPrincipal();
            UsersEntity usersEntity=usersService.login(username);
            userskillsEntity.setUserid(usersEntity.getId());
            count=userskillsService.insert(userskillsEntity);
        }else {
            count=userskillsService.update(userskillsEntity);
        }
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }


    @RequestMapping("page")
    public String page(){
         return "userskillslist";
    }
}
