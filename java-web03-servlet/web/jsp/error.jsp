<%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/17
  Time: 8:44 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page isErrorPage="true" %>
<html>
<head>
    <title>ERROR</title>
</head>
<body>
<%
    exception.getMessage();
    exception.printStackTrace(response.getWriter());
%>
ERROR !!!!!!!!!

</body>
</html>
