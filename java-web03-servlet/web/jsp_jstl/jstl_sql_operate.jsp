<%@ page import="java.util.Date" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>JSTL - SQL - OPERATE</title>
</head>
<body>
<%--连接数据库--%>
<sql:setDataSource var="snapshot" driver="com.mysql.cj.jdbc.Driver" url="jdbc:mysql://localhost:3306/sakila" user="root" password="wzy950505"/>

<%--
修改
1. 不含变量
update actor set first_name = "qinyao" where actor_id = 1

2. 含变量
update actor set last_update=? where actor_id = ?;
type：
    DATE 只有日期
    TIME 只有时间
    TIMESTAMP 日期时间
--%>
<%
    Date date = new Date();
    int id = 1;
%>
<%--;--%>
<sql:update dataSource="${snapshot}" var="count">
    update actor set last_update=? where actor_id = ?;
    <sql:dateParam value="<%=date%>" type="DATE"/>
    <sql:param value="<%=id%>" />
</sql:update>

<%--调用查询的页面 1. 先引入再编译 2. 先编译再引入 方法二可以注销jstl_sql--%>
<%--<jsp:include page="jstl_sql.jsp" flush="true"/>--%>
<%@ include file="jstl_sql.jsp"%>
</body>
</html>
