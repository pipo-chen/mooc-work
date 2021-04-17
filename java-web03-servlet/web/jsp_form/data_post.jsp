<%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/17
  Time: 5:44 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>POST 读取数据</title>
</head>
<body>
<ul>
    <li>
        <p>
            <%--    解决中文乱码问题 --%>
            <%
                String name = new String((request.getParameter("name")).getBytes("ISO-8859-1"), "UTF-8");
            %>
            <b>站点：</b>
            <%=name%>
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
