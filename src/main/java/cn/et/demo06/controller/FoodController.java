package cn.et.demo06.controller;

import cn.et.demo06.mapper.FoodMapper;
import net.sf.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

@Controller
public class FoodController {
    @Autowired
    FoodMapper foodMapper;

    @RequestMapping("/demo06/test1")
    public String foodList(OutputStream os, String name) throws IOException {
        List<Map<String, Object>> queryAllFood =foodMapper.queryAllFood(name);
        JSONArray arry =JSONArray.fromObject(queryAllFood);
        String jsonStr =arry.toString();
        os.write(jsonStr.getBytes("UTF-8"));
        return null;
    }
}
