<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/7/1 0001
  Time: 下午 11:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.js"></script>
</head>
<body>
<%
   pageContext.setAttribute("path",request.getContextPath());
%>
<h1><fmt:message key="homepage"/> </h1>
<a href="${path}/toRegister"><fmt:message key="register"/> </a>|
<a href="${path}/toLogin"><fmt:message key="login"/> </a>|
<a href="${path}/logout"><fmt:message key="logoff"/> </a>|
<a href="${path}/toSuccess" id="toSuccess" ><fmt:message key="homepage"/> </a><br/><br/>
&nbsp &nbsp &nbsp &nbsp <a href="${path}/indexi18n?locale=zh_CN">中文</a>|<a href="${path}/indexi18n?locale=en_US">English</a>
<div></div>
<%
if(request.getAttribute("isLoginErr")==null){
%>
<div></div>
<%
    }else{
%>
<script type="text/javascript">
    alert("请先登录");
</script>
<%
    }
%>

<%
if(request.getAttribute("isLogin")==null){
%>
<div></div>
<%
    }else{
%>
<script type="text/javascript">
    alert("您已登录");
</script>
<%
    }
%>

</body>



</html>
