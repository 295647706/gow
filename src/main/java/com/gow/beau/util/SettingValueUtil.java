package com.gow.beau.util;

import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Date: 2018/9/28 11:40<br/>
 * 设置对象的值
 * @author lzn
 */
public class SettingValueUtil {

    /**
     * @Author:lzn
     * @Date:2018/9/28 11:41
     * 通过反射机制，把参数一的对象字段和值设置到map中
     */
    public static Map<String,Object> settingKeyValue(Object obj, Map<String,Object> map){
        try {
            Class c = obj.getClass();
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                    //得到get的方法
                    String getMethod = "get" + StringUtils.capitalize(field.getName());
                    Method getMd = obj.getClass().getDeclaredMethod(getMethod);
                    //得到值
                    Object rs = getMd.invoke(obj);
                    if(rs != null && !rs.equals("")) {
                        map.put(field.getName(), rs);
                    }
            }
        }catch (Exception e){
            return map;
        }
        return map;
    }

    /**
     * @Author:lzn
     * @Date:2018/9/28 11:41
     * 把map 中的值设置到对象中
     */
    public static Object settingObject(Map<String,Object> map,Object obj){
        try{
            if(map != null && map.size() > 0){
                Set<String> keySets = map.keySet();
                Class c = obj.getClass();
                Field[] fields = c.getDeclaredFields();
                for(String key : keySets){
                    for(Field fd : fields){
                        if(fd.getName().equals(key)){
                            Field field=obj.getClass().getDeclaredField(key);
                            field.setAccessible(true);
                            Object value = map.get(key);
                            Class ctype = Class.forName(field.getType().getName());
                            ctype.cast(value);
                            field.set(obj,value);
                        }
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return obj;
        }
        return obj;
    }

    /**
     * @Author:lzn
     * @Date:2018/9/30 16:42
     * 把参数一的对象值根据字段赋值给参数二的对象相对应字段中
     */
    public static Object settingObject(Object beforeOdj,Object afterOdj){
        try{
            Class c = beforeOdj.getClass();
            Field[] fields = c.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(afterOdj, field);
            }
        }catch (Exception e){
            e.printStackTrace();
            return afterOdj;
        }
        return afterOdj;
    }

    /**
     * @Author:lzn
     * @Date:2018/10/18 10:20
     * 把参数一的对象值根据字段赋值给参数二的对象相对应字段中
     */
    public static Object settingObject2(Object beforeOdj,Object afterOdj){
        try{
            Map<String,Object> map = new HashMap<>();
            settingKeyValue(beforeOdj, map);
            settingObject(map, afterOdj);
        }catch (Exception e){
            e.printStackTrace();
            return afterOdj;
        }
        return afterOdj;
    }
}
