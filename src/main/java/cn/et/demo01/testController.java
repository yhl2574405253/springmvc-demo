package cn.et.demo01;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * springmvc中一个路径和方法的映射 叫做一个action（动作）
 * @author Administrator
 */
@Controller
public class testController {

    /**
     * 在以前的开发过程中取参数需要用request.getParameter("id") 来取
     */
    @RequestMapping("/test1")
    public String test1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().print("hello springMvc" + request.getParameter("id"));
        return null;
    }

    /**
     * springMvc取参数只要在方法声明一个变量，然后参数可以根据名字自动匹配
     */
    @RequestMapping("/test2")
    public String test2(String id, HttpServletResponse response) throws IOException {
        response.getWriter().print("hello springMvc"+id);
        return null;
    }

    /**
     * 如果参数多的话可以通过对象的方式来取参数
     */
    @RequestMapping("/test3")
    public String test3(User user, HttpServletResponse response) throws IOException {
        response.getWriter().print("id:" + user.getId() +"== name:"+user.getName());
        return null;
    }

    /**
     * springMvc 可以直接根据一个路径来跳转
     */
    @RequestMapping("/test4")
    public String test4(){
        return "/demo03/success.jsp";
    }
}
