<%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/17
  Time: 10:55 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp 九大内置对象 - response</title>
</head>
<body>
<%
    response.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

    Cookie cookie = new Cookie("name", "czh");
    response.addCookie(cookie);

    //重定向
    response.sendRedirect("date.jsp");
%>

</body>
</html>
