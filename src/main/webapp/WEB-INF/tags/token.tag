<%@ tag language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%

    // 创建UUID作为随机值
    String uuid = UUID.randomUUID().toString();

    // 存储到session中
    session.setAttribute("token" , uuid);
%>
<input type="hidden" name="token" value="<%=uuid%>"/>