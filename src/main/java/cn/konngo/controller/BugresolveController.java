package cn.konngo.controller;

import cn.konngo.entity.BugresolveEntity;
import cn.konngo.entity.UsersEntity;
import cn.konngo.service.BugresolveService;
import cn.konngo.service.UsersService;
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
@RequestMapping("/bugresolve")
// BUG解决方案 控制层
public class BugresolveController {
    @Autowired
    BugresolveService bugresolveService;

    @Autowired
    UsersService usersService;

    @RequestMapping("list")
    @ResponseBody
    // 返回所有BUG解决方案
    public Map list(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=bugresolveService.list();
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("search")
    @ResponseBody
    // 查询指定BUG解决方案
    public Map search(int id){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        BugresolveEntity bugresolveEntity=bugresolveService.select(id);
        map.put("entity",bugresolveEntity);
        return map;
    }


    @RequestMapping("delete")
    @ResponseBody
    // 根据id删除BUG解决方案
    public HashMap delete(int id){
        HashMap map=new HashMap();
        int count=bugresolveService.delete(id);
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }

    @RequestMapping("addOrUpdate")
    @ResponseBody
    // 添加或者修改BUG解决方案
    public HashMap saveOrUpdate(BugresolveEntity bugresolveEntity){
        HashMap map=new HashMap();

        int count=0;
        // 根据id进行判断，如果id为空或者0进行添加操作，否则进行修改
        if ((""+bugresolveEntity.getId()).equals("")||bugresolveEntity.getId()==0){
            // 添加当前用户信息
            String username = (String) SecurityUtils.getSubject().getPrincipal();
            UsersEntity usersEntity=usersService.login(username);
            bugresolveEntity.setUserid(usersEntity.getId());
            count=bugresolveService.insert(bugresolveEntity);
        }else {
            count=bugresolveService.update(bugresolveEntity);
        }
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }


    @RequestMapping("page")
    public String page(){
         return "bugresolvelist";
    }


    @RequestMapping("show")
    public String show(){
        return "bugresolve";
    }

    @RequestMapping("details")
    public String details(HttpServletRequest request,int id){
        request.setAttribute("id",id);
        return "bugdetails";
    }
}
