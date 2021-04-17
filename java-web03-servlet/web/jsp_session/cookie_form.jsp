<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/17
  Time: 6:39 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    //解决中文乱码问题
    String name_str = URLEncoder.encode(request.getParameter("name"),"UTF-8");

    //设置 name 和 url 的 cookie
    Cookie name = new Cookie("name", name_str);
    Cookie url = new Cookie("url", request.getParameter("url"));

    //设置 cookie 过期时间 24 小时
    name.setMaxAge(60 * 60 * 24);
    url.setMaxAge(60 * 60 * 24);

    //响应确认头部添加 Cookie
    response.addCookie(name);
    response.addCookie(url);
%>
<html>
<head>
    <title>设置 Cookie</title>
</head>
<body>
<ul>
    <li>
        <p>
             <b>WEB SITE NAME：</b>
            <%= request.getParameter("name")%>
        </p>
    </li>
    <li>
        <p>
             <b>URL：</b>
            <%= request.getParameter("url")%>
        </p>
    </li>
</ul>

</body>
</html>
