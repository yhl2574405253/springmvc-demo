package cn.et.demo05.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Test2 implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        String money = httpServletRequest.getParameter("money");
        if ("".equals(money) || money == null) {
            httpServletResponse.setContentType("text/html;charset=UTF-8");
            httpServletResponse.getWriter().println("转账金额不能为空！！");
            return false;
        }

        // 取出表单中的UUID
        String formUUID = httpServletRequest.getParameter("token");

        // session中的UUID
        Object sessionUUID = httpServletRequest.getSession().getAttribute("token");

        System.out.println("表单uuid: " + formUUID);
        System.out.println("session: " + sessionUUID);

        // 如果请求参数中带有UUID，则表示需要进行防止重复提交处理
        if (formUUID != null) {
            if (sessionUUID != null) {  // session中的uuid不为空，表示表单第一次提交
                if (formUUID.equals(sessionUUID.toString())) {	// 相同则通过
                    httpServletRequest.getSession().removeAttribute("token");
                    return true;
                }
            }
            // 其余情况：1.session中没有UUID、2.session中的UUID跟参数中的UUID不一致。返回false
            return false;
        }
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
