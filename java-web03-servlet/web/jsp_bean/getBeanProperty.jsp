<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Get 和 Set 属性实例</title>
</head>
<body>
<jsp:useBean id="actor" class="jsp.Actor">
    <jsp:setProperty name="actor" property="id" value="89"/>
    <jsp:setProperty name="actor" property="first_name" value="chen"/>
    <jsp:setProperty name="actor" property="last_name" value="zihan"/>
</jsp:useBean>
<p>ID：<jsp:getProperty name="actor" property="id"/></p>
<p>FIRST NAME：<jsp:getProperty name="actor" property="first_name"/></p>
<p>LAST NAME：<jsp:getProperty name="actor" property="last_name"/></p>

</body>
</html>
