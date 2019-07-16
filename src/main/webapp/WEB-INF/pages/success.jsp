<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/2 0002
  Time: 上午 1:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="form" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.js" type="text/javascript"></script>
</head>
<style type="text/css">
    #images{
        width: 50px;
        height: 50px;
    }
</style>
<body>
<%
pageContext.setAttribute("path",request.getContextPath());
%>
<h1>主页</h1><br/>
<h2>当前用户：${username}</h2>
<div>
    <img id="images" src="${imagePath}">
</div>
<a href="${path}/download">下载</a>
<br/>

<table border="1" cellpadding="5" cellspacing="1">
    <tr>
        <th>用户名</th>
        <th>密码</th>
        <th>性别</th>
        <th>出生日期</th>
        <th>编辑</th>
    </tr>
<c:forEach items="${users}" var="user">
    <tr>
        <td>${user.username}</td>
        <td>${user.password}</td>
        <td>${user.sex==0?"女":"男"}</td>
        <td>${user.birth}</td>
        <td><a href="${path}/toUpdate/${user.id}">修改</a>|<a href="${path}/delete/${user.id}" onclick="return confirmAct()">删除</a> </td>
    </tr>
</c:forEach>
</table>

</body>

<script>
    function confirmAct() {
        if(confirm("确认删除吗？")){
            return true;
        }
        return false;
    }
</script>
</html>
