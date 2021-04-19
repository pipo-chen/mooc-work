<%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/19
  Time: 3:37 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<form action="/loginServlet" method="post">
    用户名：<input type="text" name="name"/><br/>
    密码：<input type="password" name="password"/><br/>
    <font color="red">
        <%
            if(request.getAttribute("message") != null) {
                out.println(request.getAttribute("message")+"<br>");
            }
        %>
    </font>
    <input type="submit" value="提交">
</form>
</body>
</html>
