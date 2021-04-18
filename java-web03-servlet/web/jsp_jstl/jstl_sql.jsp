<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>JSTL - SQL</title>
</head>
<body>
<%--<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/sakila" user="root" password="wzy950505"/>--%>

<%--查询--%>
<sql:query var="result" dataSource="${snapshot}" sql="select * from actor"/>
<table border="1" width="100%">
    <tr>
        <td>ID</td>
        <td>fitst_name</td>
        <td>last_name</td>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.actor_id}"></c:out></td>
            <td><c:out value="${row.first_name}"></c:out></td>
            <td><c:out value="${row.last_name}"></c:out></td>
        </tr>

    </c:forEach>

</table>

</body>
</html>
