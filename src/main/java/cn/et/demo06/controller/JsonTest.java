package cn.et.demo06.controller;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonTest {
    /**
     {
     id:1
     username:'A'
     }
     */
    public static void Json(){
        Map map =new HashMap();
        map.put("id", 1);
        map.put("username", "A");

        JSONObject jObject =JSONObject.fromObject(map);
        System.out.println(jObject.toString());

    }
    /**
     *[
     * 	{
     *		id:3,
     *		username:'A',
     *		money:80
     * 	},
     * 		id:4,
     * 		username:'B',
     * 		money:100
     *]
     *
     *
     *json字符串的键一定要带 "key":1
     *值 数字不需要"" 字符串必须到带
     */
    public static void listJson(){
        Map map =new HashMap();
        map.put("id", 1);
        map.put("username", "A");

        Map map1 =new HashMap();
        map1.put("id", 2);
        map1.put("username", "B");

        List list =new ArrayList();
        list.add(map);
        list.add(map1);

        JSONArray jObject =JSONArray.fromObject(list);
        System.out.println(jObject.toString());
    }

    public static void JsonObjct(){
        Map map =new HashMap();
        map.put("id", 1);
        map.put("username", "A");

        Map address =new HashMap();
        address.put("city", "zs");
        address.put("stree", "gl");
        map.put("address", address);

        JSONObject jObject =JSONObject.fromObject(map);
        System.out.println(jObject.toString());
    }
    public static void main(String[] args) {
//		Json();
//		listJson();
        JsonObjct();
    }
}
