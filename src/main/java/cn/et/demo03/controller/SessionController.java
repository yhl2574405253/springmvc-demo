package cn.et.demo03.controller;
import cn.et.demo01.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;
/**
 * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外(实际上使用的是 value 属性值),
 * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中(实际上使用的是 types 属性值)
 * 注意: 该注解只能放在类的上面. 而不能修饰方法当于在map中和session中 各存放了一个实体类，一个String类的字符串
 */
@SessionAttributes("user")
@Controller
public class SessionController {

	@ModelAttribute("user")
	public User getUser(){
		User user = new User();
		return user;
	}
	/**
	 * http://localhost:8080/s/s1?id=1
	 * 请求转发 forward: 不需要任何处理
	 * 请求重定向 redirect: 使用SessionAttribute方式 用于在重定向中传至  将值存储在session中 【用完记住清除】
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value="/s1",method=RequestMethod.GET)
	public String case1(@ModelAttribute("user") User user) throws Exception{
		return "redirect:/s2";
	}


	@RequestMapping(value="/s2",method=RequestMethod.GET)
	public String case2(Map map,HttpServletResponse res,SessionStatus sessionStatus) throws Exception{
		User user=(User)map.get("user");
		res.getWriter().println(user.getId());
		sessionStatus.setComplete();
		return null;
	}

}
