package cn.et.demo03.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
/**
 *  springmvc中Model相关对象 是处理和数据相关的对象
 *  @ModelAttribute 重命名 参数数据
 * Model(ModelMap或者Map)传递数据到视图(request.setAttribute)
 *
 */
@Controller
public class ModeController {
    @RequestMapping("/case")
    public String case1(Map map) throws Exception{
        map.put("sex", "获取成功!!");
        return "/demo03/mapper.jsp";
    }


    /**
     * ModelAndView 绑定数据到视图 （ModelMap用于传递数据 View对象用于跳转）
     * @return
     * @throws Exception
     */
    @RequestMapping(value="/case2")
    public ModelAndView case2() throws Exception {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/demo03/mapper.jsp");
        mav.addObject("sex", "boy");
        return mav;
    }
}
