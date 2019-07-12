<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String str = ";asdasd";
    String str1 = "";
    request.setAttribute("str", str);
    request.setAttribute("str1", str1);
%>
<html>
    <head>
        <title>empty&&pageContext</title>
    </head>
    <body>

        <h3>空运算符：empty</h3>
        <p>功能：用于判断字符串、集合、数组对象是否为null或者长度是否为0</p>
        ${empty list} :list为空 <br>
        ${empty str} :str有值 <br>
        ${not empty str} :str有值 <br>
        ${empty str1} :str为""这个也为false  <br>
    </body>
</html>
