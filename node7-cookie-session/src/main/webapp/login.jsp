<% String fc = (String) request.getSession().getAttribute("fc"); %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script src="jquery-3.3.1.js" type="text/javascript" charset="utf-8"></script>
    <script>
        $(function(){
            $("img").click(function () {
                // 加时间戳
                var time = new Date().getTime();
                $("img").attr("src","/node7/checkCodeServlet?"+time);
            });

            alert($("#fc").text());

        })
    </script>
</head>
<body>
    <form action="/node7/login" method="post">
        username:<input name="username" placeholder="请输入用户名" type="text" required="required" id="username" /><br>
        password:<input name="password" placeholder="请输入密码" type="password" required="required" id="password" /><br>
        checkCode:<input name="checkCode" placeholder="请输入验证码" type="text" required="required" id="checkCode" ><br>
        <img src="/node7/checkCodeServlet" alt="验证码"><br>
        <input type="submit" value="登录"><br>
    </form>
    <span id="fc" style="display: none"><%=fc%></span>

</body>
</html>