<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<html>
<head>
    <title>JSTL - SQL : Transaction</title>
</head>
<body>
<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/sakila" user="root" password="wzy950505"/>

<%
    int actor_id = 1;
%>
<%--事务--%>
<sql:transaction dataSource="${snapshot}" >
    <sql:update var="count">
        update actor set first_name = "wang" where actor_id=?;
        <sql:param value="<%=actor_id%>"/>
    </sql:update>

    <sql:update var="count">
        update actor set first_name = "chen" where actor_id = 2;
    </sql:update>
</sql:transaction>

<%@ include file="jstl_sql.jsp"%>
</body>
</html>
