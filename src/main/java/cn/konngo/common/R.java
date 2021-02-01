package cn.konngo.common;

import cn.konngo.entity.UsersEntity;

import java.util.HashMap;
import java.util.Map;

public class R {
    private static Map map=new HashMap();

    public static Map ok(){
        map.put("code","0");
        map.put("msg","");
        return map;
    }

    public static Map ok(String msg){
        map.put("code","0");
        map.put("msg",msg);
        return map;
    }

    public static Map error(String msg){
        map.put("code","1");
        map.put("msg",msg);
        return map;
    }

    public static Map ok(String str, Object obj) {
        map.put("code","0");
        map.put("msg","");
        map.put(str,obj);
        return map;
    }
}
