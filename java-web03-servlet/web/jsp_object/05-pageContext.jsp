<%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/17
  Time: 11:24 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp 九大内置对象 - pageContext</title>
</head>
<body>
<%
    String localAddr = pageContext.getRequest().getLocalAddr();
    out.println(localAddr);
%>
<br>
<%
    out.println(page.toString());
%>

</body>
</html>
