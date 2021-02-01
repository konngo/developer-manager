package cn.konngo.controller;

import cn.konngo.entity.SkilltypeEntity;
import cn.konngo.service.SkilltypeService;
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
@RequestMapping("/skilltype")
// 技能分类 控制层
public class SkilltypeController {
    @Autowired
    SkilltypeService skilltypeService;


    @RequestMapping("list")
    @ResponseBody
    // 返回所有技能分类
    public Map list(){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        List list=skilltypeService.list();
        map.put("count",list.size());
        map.put("aaData",list);
        return map;
    }

    @RequestMapping("search")
    @ResponseBody
    // 查询指定技能分类
    public Map search(int id){
        Map map=new HashMap();
        map.put("code","0");
        map.put("msg","");
        SkilltypeEntity skilltypeEntity=skilltypeService.select(id);
        map.put("entity",skilltypeEntity);
        return map;
    }


    @RequestMapping("delete")
    @ResponseBody
    // 根据id删除技能分类
    public HashMap delete(int id){
        HashMap map=new HashMap();
        int count=skilltypeService.delete(id);
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }

    @RequestMapping("addOrUpdate")
    @ResponseBody
    // 添加或者修改技能分类
    public HashMap saveOrUpdate(SkilltypeEntity skilltypeEntity){
        HashMap map=new HashMap();

        int count=0;
        // 根据id进行判断，如果id为空或者0进行添加操作，否则进行修改
        if ((""+skilltypeEntity.getId()).equals("")||skilltypeEntity.getId()==0){
            count=skilltypeService.insert(skilltypeEntity);
        }else {
            count=skilltypeService.update(skilltypeEntity);
        }
        int flag=count>0?0:1;
        map.put("code",flag);
        return map;
    }


    @RequestMapping("page")
    public String page(){
         return "skilltypelist";
    }
}
