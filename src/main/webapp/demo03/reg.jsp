<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
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
<form action="/demo03/test1" method="post">
    用户名 :<input type="text" name="userName"/><form:errors path="userInfo.userName" cssStyle="color: red" /><br/>
    密码 :<input type="password" name="password"/><form:errors path="userInfo.password" cssStyle="color: red" /></br>
    重复密码 :<input type="password" name="repassword"/><form:errors path="userInfo.repassword" cssStyle="color: red" /></br>
    邮件 :<input type="text" name="email"/><form:errors path="userInfo.email" cssStyle="color: red" /></br>
    年龄:<input type="text" name="age"/><form:errors path="userInfo.age" cssStyle="color: red" /></br>
    手机号码:<input type="text" name="phone"/><form:errors path="userInfo.phone" cssStyle="color: red" /></br>
    时间:<input type="text" name="date"/><form:errors path="userInfo.date" cssStyle="color: red" /></br>
    网址:<input type="text" name="url"/><form:errors path="userInfo.url" cssStyle="color: red" /></br>
    <input type="button" onclick="checkSubmit()" value="注册"/>
</form>
</body>
</html>