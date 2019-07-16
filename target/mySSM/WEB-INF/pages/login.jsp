<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/3 0003
  Time: 下午 8:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<%
pageContext.setAttribute("path",request.getContextPath());
%>
<h1>登录</h1>
<form action="${path}/login" method="post">
<%--    用户名:<input type="text" name="username">${loginErr}<br/>--%>
    用户名:<input type="text"  id="username" ><span id="a"></span><br/>
    密码:<input type="password" name="password">${passwordErr}<br/>
    确认密码：<input type="password" name="confirmPassword"><br/>
    <input type="submit" value="登录">
</form>
</body>

<script>
    $("#username").blur(function () {
         $.ajax({
             url:"${path}/username",
             type:"post",
             // 将数据传给controller
             data:{username:$("#username").val()},
             // 告诉浏览器返回什么类型的数据
             dataType: "json",
             success:function (data) {
                $("#a").html(data);
             }
         })
    })
</script>

</html>
