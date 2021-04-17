<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>获取 Cookie</title>
</head>
<body>
<%
    Cookie cookie = null;
    Cookie[] cookies = null;

    //获取 cookie 数据是一个数组
    cookies = request.getCookies();
    if (cookies != null) {
    	out.println("<h2>查找 Cookie 名与值</h2>");
    	for (int i = 0; i < cookies.length; i++) {
    		cookie = cookies[i];
    		if ((cookie.getName()).compareTo("name") == 0) {
    			cookie.setMaxAge(0);
    			response.addCookie(cookie);
    			out.println("删除Cookie:"+cookie.getName() + "<br/>");
            }
    		out.println("参数名:" + cookie.getName());
    		out.println("<br>");
    		out.println("参数值:" + URLDecoder.decode(cookie.getValue(),"utf-8") + "<br>");
    		out.println("-----------------------------------<br>");

        }
    } else {
    	out.println("<h2>没有发现 Cookies </h2>");
    }
%>

</body>
</html>
