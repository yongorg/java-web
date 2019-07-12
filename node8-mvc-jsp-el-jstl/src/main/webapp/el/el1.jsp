<%@ page import="node.entity.User" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>获取数据</title>
    </head>
    <body>
        ${3 > 4}

        <%
            session.setAttribute("name", "nijie");
            request.setAttribute("name", "lyy");
            session.setAttribute("age", "23");
            request.setAttribute("str", "s");
        %>
        <h3>el获取值</h3>
        ${requestScope.name}
        ${sessionScope.name}
        ${sessionScope.age}
        ${sessionScope.haha}
        ${name} <%--  键名依次从最小的域中查找对应值，直到找到为止  --%>
        <hr>


        <%
            User nijie = User.builder().name("nijie").age(18).birthday(new Date()).build();
//            String simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
            request.setAttribute("u", nijie);
        %>
        <h3>el获取对象中的值</h3>
        ${requestScope.u}<br>
        <%--
                通过对象中的属性来获取
                    * setter或getter方法，去掉set或get，在将剩余部分的首字母边小写
        --%>
        ${ requestScope.u.name }<br>
        ${ u.age }<br>
        ${u.birthday}<br>
        ${u.birthday.month+1}月<br>
        ${u.birStr}<br>
        <hr>

        <h3>el获取List中的值</h3>
        <%
            List<String> list = new ArrayList<>();
            list.add("nijie");
            list.add("lyy");
            list.add("zhengyong");
            list.add("fjj");

            request.setAttribute("list", list);
        %>
        ${requestScope.list}<br>
        ${list}<br>
        ${list[0]}<br>
        ${list[2]}<br>
        ${list[12]}<br><%--  下标越界显示空字符串，不报异常 --%>
        <h3>el获取Map中的值</h3>
        <%
            Map<String, String> map = new HashMap<>();
            map.put("name", "nijie");
            map.put("age", "18");
            map.put("date", "2019");


            request.setAttribute("map", map);
        %>
        ${map}<br>
        ${map.name}<br>
        ${map.age}<br>
        ${map.date}<br>
        ${map.hehe}<br><hr>

    </body>
</html>
