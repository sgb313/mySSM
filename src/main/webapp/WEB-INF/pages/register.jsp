<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/2 0002
  Time: 上午 12:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="js/jquery.js"></script>
</head>
<body>
<%
    pageContext.setAttribute("path",request.getContextPath());
%>
<form action="${path}/register" method="post" enctype="multipart/form-data">
    <fmt:message key="username"/> ：<input type="text" name="username"/> ${err}${nameExist}<br/>
    <fmt:message key="password"/> ：<input type="password" name="password"/>${err}<br/>
    <fmt:message key="sex"/> ：&nbsp &nbsp &nbsp
    <fmt:message key="men"/> <input type="radio" name="sex" value="1">
    <fmt:message key="women"/> <input type="radio" name="sex" value="0"><br/>
    <fmt:message key="birth"/> ：<input type="date" name="birth"><br/>
    <fmt:message key="image"/>: <input type="file" name="file"><br/>
    <input type="submit" value="<fmt:message key="sumbit"/> "><br/>
    <a href="${path}/registeri18n?locale=zh_CN">中文</a>|<a href="${path}/registeri18n?locale=en_US">English</a>
</form>

</body>
</html>
