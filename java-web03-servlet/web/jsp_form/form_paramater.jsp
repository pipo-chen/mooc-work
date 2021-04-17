<%@ page import="java.util.Enumeration" %><%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/17
  Time: 6:03 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>读取所有表单信息</title>
</head>
<body>
<table width="100%" border="1" align="center">
    <tr bgcolor="#663399">
        <th>参数名</th>
        <th>参数值</th>
    </tr>
    <%
        Enumeration paramNames = request.getParameterNames();

        while (paramNames.hasMoreElements()) {
        	String paramName = (String) paramNames.nextElement();
        	out.println("<tr><td>" + paramName + "</td>\n");
        	String paramValue = request.getParameter(paramName);
        	out.println("<td>"+ paramValue+"</td></tr>\n");
        }
    %>
</table>


</body>
</html>
