<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>My JSP 'list.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script type="text/javascript">
        function query() {
            //无刷新调用 http://localhost:8080/demo06/test1 获取到数据 数据通过dom方式添加到 table中

            //ajax(异步的ajax)+json
            var xmlhttp = new XMLHttpRequest();

            //回调函数 当请求发送后  收到结果自动调用该方法
            xmlhttp.onreadystatechange = function() {
                /*
                存在XMLHttpRequest 的状态  readyState从0到4发生变化
                    0:请求未初始化（没有调用send方法）
                    1:服务器连接已建立（socket已连接）
                    2:请求已接收 （获取到了参数 没有执行 action方法）
                    3:请求处理中  （已经在执行action方法 未执行完）
                    4:请求已完成，且响应已就绪	 （已经响应 并且能获取到最终的数据）
                    status 响应的状态
                */
                if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
                    //返回的是字符串的json
                    var resutlJson = xmlhttp.responseText;
                    //转换为js对象
                    var resultObj=JSON.parse(resutlJson);
                    //获取表格对象
                    var table=document.getElementById("myTable");
                    //将所有名字为 dataTr的tr全部删除  [a,b,c]
                    var allDataTr=document.getElementsByName("dataTr");
                    var length=allDataTr.length;
                    for(var i=0;i<length;i++){
                        table.removeChild(allDataTr[0]);
                    }
                    //根据json的行数追加多个tr
                    for(var i=0;i<resultObj.length;i++){
                        var obj=resultObj[i];
                        var td=document.createElement("td");
                        td.innerText=obj.name;
                        var td1=document.createElement("td");
                        td1.innerText= obj.price;
                        var tr=document.createElement("tr");
                        tr.setAttribute("name","dataTr");
                        tr.appendChild(td);
                        tr.appendChild(td1);
                        table.appendChild(tr);
                    }
                }
            }
            var name = document.getElementsByName("foodName")[0].value;

            //post提交
            // 一个ajax线程是否执行完成，可以通过回调函数  xmlhttp.onreadystatechange 是否执行完成来判断
            //异步 多个线程同时执行 无法判断 谁先执行 true
            //同步 一次只允许一个线程执行 false 页面会假死
            xmlhttp.open("POST", "/demo06/test1", true);
            xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=UTF-8");
            xmlhttp.send("name=" + name);
        }
    </script>
</head>



<body>
    <input type='text' name="foodName" />
    <input type='button' value="查询" onclick="query()">
    <table id="myTable">
        <tr><th>菜品名</th><th>菜品价格</th></tr>
    </table>
</body>
</html>
