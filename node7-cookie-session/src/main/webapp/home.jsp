<%@ page import="java.net.URLDecoder" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %><%--
  Created by IntelliJ IDEA.
  User: 14350
  Date: 2019/5/20
  Time: 10:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%  request.setCharacterEncoding("utf-8");
    response.setContentType("text/html;charset=utf-8");

    // 1. 获取所有的cookie
    Cookie[] cookies = request.getCookies();
    // 2. 遍历cookie
    boolean result = false;
    if (cookies != null && cookies.length > 0) {
        for (Cookie cookie : cookies) {
            String name = cookie.getName();
            // 4. 判断名称是否有lastTime
            if (name.equals("lastTime")) {
                // 有 说明不是第一访问
                String value = cookie.getValue();
                %>
                  <h1>欢迎回来，您上次访问时间为:<%=URLDecoder.decode(value, "UTF-8")%></h1>
<%


                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日--HH:mm:ss.SSS");
                String lastTime = sdf.format(date);
                String encode = URLEncoder.encode(lastTime, "UTF-8");

                cookie.setValue(encode);
                response.addCookie(cookie);
                result=true;
                break;
            }
        }

    }
    if (cookies == null || cookies.length == 0 || result==false) {
%>
        <h1>您好，欢迎您首次访问</h1>
<%
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日--HH:mm:ss.SSS");
        String lastTime = sdf.format(date);
        Cookie lastTimecookie = new Cookie("lastTime", URLEncoder.encode(lastTime, "UTF-8"));
        response.addCookie(lastTimecookie);
    }
%>
</body>
</html>
