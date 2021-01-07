package com.jiming.daily.utils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

/**
 * 功能：alibaba JSON 工具类
 * 说明：
 * @author Mr.tjm
 * @date 2020-5-20 11:25
 */
public class JsonUtils {

    public JsonUtils() {
    }

    public static <T> T parseObject(String json, Class<T> clazz) {
        return JSONObject.parseObject(json, clazz);
    }

    public static <T> List<T> parseArray(String json, Class<T> clazz) {
        return JSONObject.parseArray(json, clazz);
    }

    public static String parseArray(Object list) {
        return JSONArray.toJSONString(list);
    }

    public static String parseObject(Object obj) {
        return JSONObject.toJSONString(obj);
    }

    public static String replaceSpecialStr(String jsonStr) {
        if (jsonStr != null && !"".equals(jsonStr)) {
            StringBuilder sb = new StringBuilder();

            for(int i = 0; i < jsonStr.length(); ++i) {
                char c = jsonStr.charAt(i);
                switch(c) {
                    case '"':
                        sb.append("\\\"");
                        break;
                    case '\\':
                        sb.append("\\\\");
                        break;
                    default:
                        sb.append(c);
                }
            }

            return sb.toString();
        } else {
            return jsonStr;
        }
    }

}
