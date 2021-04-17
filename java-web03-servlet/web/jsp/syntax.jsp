<%@ page import="jsp.User" %>
<%@ page errorPage="error.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="Hello.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%-- jsp 中两种 include 区别：
    <%@ include page ="hello.jsp" %>
    1. 静态 include 是在编译阶段执行

    <jsp:include page = "hello.jsp"><jsp:include>
    2. 动态 include 在请求处理阶段执行
--%>
<html>
<head>
    <title>jsp 语法</title>
</head>
<body>
<%
    out.println("你的 IP 地址："+ request.getRemoteAddr());

    //异常信息演示
    //throw new RuntimeException("我出错了");
%>
<%
    int i = 0;
    int a, b, c;
    //导入头部文件
    User user = new User();
    int day = 3;
    int fontSize;
%>
<hr/>
<%@ include file="Hello.jsp"%>
<%-- 该部分注释不会在网页中呈现 --%>
<!-- 该部分注释可以在网页源码中展示出来 -->
<hr/>
<p>
    今天的日期是：<%=new java.util.Date().toString()%>
    <br/>
    Session ID:<%= session.getId()%>
    <br/>
    application context path:<%=application.getContextPath()%>
    <br/>
    application servlet context path:<%=application.getServletContextName()%>
    <br/>
</p>

<hr/>
<h1>控制流程语句</h1>
<% if (day == 6 || day == 7) { %>
        <p>今天是周末<p>
    <% } else { %>
        <p>今天不是周末</p>
    <% } %>
<h1>控制流程语句</h1>
<%
    switch(day) {
        case 6:
        	out.println("星期六");
        	break;
        case 7:
        	out.println("星期日");
        	break;
        default:
        	out.println("星期"+day);
        	break;
    }
%>

<hr/>
<h1>循环语句</h1>

<% for (fontSize = 1; fontSize <= 3; fontSize++) { %>
<font color="#663399" size="<%=fontSize%>">for 循环演示</font>
<% } %>

<% while (fontSize <= 6) { %>
<font color="yellow" size="<%=fontSize%>">while 循环演示</font>
<%fontSize++;%>
<% } %>
<hr/>
 <jsp:include page="Hello.jsp"></jsp:include>
<hr/>

</body>
</html>
