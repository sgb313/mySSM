<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/4 0004
  Time: 下午 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.js" type="text/javascript"></script>
</head>
<body>
<%
pageContext.setAttribute("path",request.getContextPath());
%>
<h1>修改</h1><br/>
<form:form modelAttribute="user" action="${path}/update" method="post">
    <input type="hidden" name="id" value="${user.id}">
   用户名： <form:input path="username"></form:input><br/>
    密码：<form:password path="password"></form:password><br/>
    性别：&nbsp &nbsp
    男：<form:radiobutton path="sex" value="1"></form:radiobutton>
    女：<form:radiobutton path="sex" value="0"></form:radiobutton><br>
    出生日期：<input type="date" value="${user.birth}" name="birth"><br/>
    <input type="submit" value="修改">
</form:form>
</body>
</html>
