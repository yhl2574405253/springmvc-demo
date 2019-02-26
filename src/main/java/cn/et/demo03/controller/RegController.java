package cn.et.demo03.controller;


import cn.et.demo03.model.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * 后台验证步骤
 *   1 javabean添加验证注解
 *   2 action中使用 @Valid表示javabean 使用 Errors或者BindingResult判断是否验证失败
 *   3 出现jar包冲突  4.3.2
 *   配置spring监听器 在使用springmvc的标签或者国际化中 都需要spring的支持
 * @ModelAttribute user 用来修改名字
 *
 */
@Controller
public class RegController {
	/**
	 * 注解的方式校验数据
	 * @param userInfo
	 * @param error
	 * @return
	 */
	@RequestMapping(value = "/demo03/test1",method = RequestMethod.POST)
	public String  test1(@Valid UserInfo userInfo,BindingResult error){
//		如果有异常就跳转到注册的页面提示错误信息
	    if (error.hasErrors()){
			return "/demo03/reg.jsp";
		}
//		验证成功就跳转到成功页面
		return "/demo03/success.jsp";
	}

    /**
     * 编程的方式校验数据
     * @param userInfo
     * @param error
     * @return
     */
	@RequestMapping( "/demo03/test2")
	public String test2(@Valid UserInfo userInfo, BindingResult  error){
		if(StringUtils.isEmpty(userInfo.getUserName())){
			error.addError(new FieldError("userInfo", "userName", "两次密码不一致"));
		}
		if(error.hasErrors()){
			return "/demo03/reg.jsp";
		}
		return "/demo03/success.jsp";
	}

    /**
     * @ModelAttribute("user") 可以给异常消息取一个别名
     * @param userInfo
     * @param error
     * @return
     */
	@RequestMapping("/demo03/test3")
    public String test3(@ModelAttribute("user") @Valid UserInfo userInfo, BindingResult error){
	    if (error.hasErrors()){
            return "/demo03/reg.jsp";
        }
        return "/demo03/success.jsp";
    }
}
