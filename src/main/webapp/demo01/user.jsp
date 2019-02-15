
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--添加--%>
    <form action="${pageContext.request.contextPath}/user" method="post">
        <input type="text" name="name"/>
        <input type="submit" value="添加"/>
    </form>
    <br/>
    <%--删除--%>
    <form action="${pageContext.request.contextPath}/user/delete" method="post">
        <input  type="hidden" name="_method" value="delete"/>
        <input type="text" name="name"/>
        <input type="submit" value="删除"/>
    </form>
    <br/>
    <%--修改--%>
    <form action="${pageContext.request.contextPath}/user/update" method="post">
        <input  type="hidden" name="_method" value="put"/>
        <input type="text" name="id"/>
        <input type="submit" value="修改"/>
    </form>
</body>
</html>