<%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/19
  Time: 5:21 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Welcome</title>
</head>
<body>
<%--  获取登录信息 --%>
<b>欢迎您，</b><%=request.getParameter("name")%>
</body>
</html>
