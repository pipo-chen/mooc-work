<%--
  Created by IntelliJ IDEA.
  User: ct
  Date: 2021/4/17
  Time: 7:57 上午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp life cycle</title>
</head>
<body>
<%!
    private int initVar = 0;
    private int serviceVar = 0;
    private int destroyVar = 0;
%>
<%!
    public void jspInit() {
    	initVar++;
    	System.out.println("jspInit(): JSP 被初始化了"+initVar+"次");
    }

    public void jspDestroy() {
    	destroyVar++;
    	System.out.println("jspInit(): JSP 被销毁了"+destroyVar+"次");
    }
%>
<%
    serviceVar++;
    System.out.println("jspService():JSP 共响应了"+serviceVar+"次");

    String content1 = "初始化次数："+ initVar;
    String content2 = "响应客户请求次数："+serviceVar;
    String content3 = "销毁次数："+destroyVar;
%>
<p><%=content1%></p>
<p><%=content2%></p>
<p><%=content3%></p>

</body>
</html>
