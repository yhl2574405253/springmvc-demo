<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>My JSP 'login.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript">
        function checkSubmit(){
            document.forms[0].submit();
        }

    </script>
</head>

<body>
    <s:message code="language"></s:message>: 
    <a href="<%=path %>/demo04/mid?locale=zh_CN"><s:message code="Chinese"></s:message></a>
    <a href="<%=path %>/demo04/mid?locale=en_GB"><s:message code="English"></s:message></a>
    <form action="<%=path %>/demo04/reg" method="post">
        <s:message code="userName"></s:message> :<input type="text" name="userName"/><form:errors path="userInfo.userName" cssStyle="color: red"/> <br/>
        <s:message code="password"></s:message> :<input type="password" name="password"/><br/>
        <s:message code="repassword"></s:message> :<input type="password" name="repassword"/><br/>
        <s:message code="email"></s:message> :<input type="text" name="email"/><br/>
        <s:message code="age"></s:message> :<input type="text" name="age"/><br/>
        <s:message code="phone"></s:message> :<input type="text" name="phone"/><br/>
        <s:message code="date"></s:message> :<input type="text" name="date"/><br/>
        <s:message code="url"></s:message> :<input type="text" name="url"/><br/>
        <button onclick="checkSubmit()"><s:message code="register"></s:message> </button>
    </form>
</body>
</html>