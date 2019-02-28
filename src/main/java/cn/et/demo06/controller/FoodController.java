package cn.et.demo06.controller;

import cn.et.demo06.mapper.FoodMapper;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Controller
public class FoodController {
    @Autowired
    FoodMapper foodMapper;

    /**
     * 最原始的方法 通过outputStream输出
     * @param os
     * @param name
     * @return
     * @throws IOException
     */
    @RequestMapping("/demo06/test1")
    public String test1(OutputStream os, String name) throws IOException {
        List<Map<String, Object>> queryAllFood =foodMapper.queryAllFood(name);
        JSONArray arry =JSONArray.fromObject(queryAllFood);
        String jsonStr =arry.toString();
        os.write(jsonStr.getBytes("UTF-8"));
        return null;
    }

    /**
     * 用@ResponseBody的方式直接返回,减少流的输出动作
     * @param name
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/demo06/test2")
    public byte [] test2(String name){
        List<Map<String, Object>> queryAllFood =foodMapper.queryAllFood(name);
        JSONArray arry =JSONArray.fromObject(queryAllFood);
        String jsonStr =arry.toString();
        return jsonStr.getBytes();
    }

    /**
     * 配置消息转换器 springmvc自己帮你转换成json格式
     * @param name
     * @return
     */
    @ResponseBody
    @RequestMapping("/demo06/test3")
    public List<Map<String, Object>> test3(String name){
        List<Map<String, Object>> queryAllFood =foodMapper.queryAllFood(name);
        return queryAllFood;
    }
}
