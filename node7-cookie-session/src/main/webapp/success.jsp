<% Student stu = (Student)session.getAttribute("stu"); %>
<%@ page import="anli.entity.Student" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1><%=stu.getName() %>:欢迎您！</h1>
</body>
</html>
