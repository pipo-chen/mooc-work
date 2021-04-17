<%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/17
  Time: 5:36 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>GET 读取数据</title>
</head>
<body>
<%--http://localhost:8080/jsp_form/data_get.jsp?name=test&url=www.baidu.com--%>
<h1>使用 GET 获取数据</h1>
<ul>
    <li>
        <p>
            <b>站点名：</b>
            <%= request.getParameter("name")%>
        </p>
    </li>
    <li>
        <p>
            <b>网址：</b>
            <%= request.getParameter("url")%>
        </p>
    </li>
</ul>

</body>
</html>
