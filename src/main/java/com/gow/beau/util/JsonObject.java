package com.gow.beau.util;

import java.util.Map;

/**
 * Created by lzn on 2019/2/28.
 */
public class JsonObject {

    /**
     * lzn 2019/2/28 21:22
     * map 转 json
     */
    public static String mapToJson(Map<String,Object> map){
        String json = null;
        try{
            if(map != null && map.size() > 0 ){
                for(String key : map.keySet()){
                    if(null == json){
                        json = "\""+key+"\""+":"+map.get(key);
                    }else{
                        json += ","+"\""+key+"\""+":"+map.get(key);
                    }
                }
                json = "{"+json+"}";
            }
        }catch (Exception e){
            throw new RuntimeException("自定义json格式转化异常:",e);
        }
        return json;
    }
}
