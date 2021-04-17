<%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/17
  Time: 10:17 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Date</title>
</head>
<body>
<%
    java.util.Date date = new java.util.Date();
%>
<p>
    today is :<%=date.toString()%>
</p>

</body>
</html>
