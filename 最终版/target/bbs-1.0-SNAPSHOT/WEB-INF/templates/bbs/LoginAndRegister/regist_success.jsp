<%--
  Created by IntelliJ IDEA.
  User: 11251
  Date: 2019/7/4
  Time: 14:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body style="background-color: #ebeaea">
<div style="background-color: WHITE;width: 400px;
    height: 200px;
    margin-top: 100px;
    margin-right: auto;
    margin-left: auto;
    border-radius: 5px;
    padding: 20px;
    border:2px solid  #ebeaea;
    background-color: white;">
<h2 style="color: #ff9427;margin-top: 60px;margin-left:30px">注册成功，3秒后跳回到登录界面</h2>
<h2 style="margin-left: 60px">如果没有跳转，请按<a href="/loginjsp.action">这里</a> </h2></div>
<%
    session.invalidate();
    response.setHeader("refresh","3;URL=/loginjsp.action");
%>
</body>
</html>
