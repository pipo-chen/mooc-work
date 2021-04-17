<%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/17
  Time: 11:20 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp 九大内置对象 - config</title>
</head>
<body>
<%
    String servletName = config.getServletName();
//    String servletName = pageContext.getServletConfig().getServletName();
    out.println(servletName);

//    String serveInfo = pageContext.getServletConfig().getServletContext().getServerInfo();
    String serveInfo = config.getServletContext().getServerInfo();
    out.println(serveInfo);
%>

</body>
</html>
