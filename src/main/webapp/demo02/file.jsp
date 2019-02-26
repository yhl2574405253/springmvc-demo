<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/file/fileUpload" method="post" enctype="multipart/form-data">
        <input type="file" name="fileName"/>
        <button type="submit">提交</button>
    </form>
    <a href="${pageContext.request.contextPath}/file/fileDownload?fileName=demo1.jpg">文件一</a>
    <a href="${pageContext.request.contextPath}/file/fileDownload?fileName=demo2.png">文件二</a>
</body>
</html>
