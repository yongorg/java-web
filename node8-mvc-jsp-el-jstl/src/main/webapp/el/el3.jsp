<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String str = "asdasd";
    String str1 = "";
    request.setAttribute("str", str);
    request.setAttribute("str1", str1);
%>
<html>
    <head>
        <title>el隐式对象</title>
    </head>
    <body>
        ${pageContext.request}<br>
        <h4>动态获取虚拟目录</h4>
        ${pageContext.request.contextPath}

    </body>
</html>
