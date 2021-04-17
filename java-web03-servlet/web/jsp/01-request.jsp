<%@ page import="java.net.UnknownServiceException" %>
<%@ page import="jsp.User" %><%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/17
  Time: 10:45 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp 九大内置对象 - request</title>
</head>
<body>
<%
    request.setCharacterEncoding("utf-8");

    String name = request.getParameter("name");
    String id = request.getParameter("id");
    String age = request.getParameter("age");

    User user = new User();
    user.setId(Integer.parseInt(id));
    user.setAge(Integer.parseInt(age));
    user.setName("Wang");
    out.println(user.toString());

    //正常的话 就会跳转到 date.jsp 文件 http://localhost:8080/jsp/01-request.jsp?id=18&age=1111
    request.getRequestDispatcher("date.jsp").forward(request, response);
%>

</body>
</html>
