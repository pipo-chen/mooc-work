<%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/17
  Time: 10:22 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp 动作元素 - userBean</title>
</head>
<body>
<jsp:useBean id="user" class="jsp.User"/>
<jsp:setProperty property="id" name="user" value="30212321"/>
<jsp:setProperty property="name" name="user" value="wang"/>
<jsp:setProperty property="age" name="user" value="16"/>

<p>输出 User 信息</p>
<jsp:getProperty name="user" property="id"/>
<br>
<jsp:getProperty name="user" property="name"/>
<br>
<jsp:getProperty name="user" property="age"/>
<br>
</body>
</html>
