<%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/17
  Time: 5:57 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>从 Checkbox 中读取数据</title>
</head>
<body>
<ul>
    <li>
        <p>
            <b>网易是否选中</b>
            <%= request.getParameter("163")%>

        </p>
    </li>
    <li>
        <p>
            <b>BAIDU是否选中</b>
            <%=request.getParameter("baidu")%>
        </p>
    </li>
    <li>
        <p>
            <b>淘宝是否选中</b>
            <%=request.getParameter("taobao")%>
        </p>
    </li>
</ul>

</body>
</html>
