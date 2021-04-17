<%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/17
  Time: 11:16 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp 九大内置对象 - application</title>
</head>
<body>
<%
    //统计服务器的总浏览次数，application 是与服务器共存亡，seeeion 是与浏览器共存亡
    Object ob = application.getAttribute("count");

    int num = 0;
    if (ob == null) {
    	num = 1;
    } else {
    	num = Integer.valueOf(ob.toString()) + 1;
    }
    application.setAttribute("count", num);;
%>
<h3>
    总浏览人数：<%=application.getAttribute("count")%>
</h3>

</body>
</html>
