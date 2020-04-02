<%--
  Created by IntelliJ IDEA.
  User: 11251
  Date: 2019/7/3
  Time: 8:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->
    <link href="../../../../static/bbs/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../../../static/bbs/css/login.css" rel="stylesheet">
</head>
<body>
<jsp:include page="/WEB-INF/templates/bbs/LoginAndRegister/header.jsp"/>
<div class="login">

    <form id="form1" role="form" action="/login.action" method="post">
        <!--<label for="name">用户名:</label>-->
        <input id="username" required type="text" class="form-control" name="username" style="height: 55px; margin-top: 30px;"
               placeholder="请输入用户名"><s:fielderror fieldName="username"></s:fielderror>
        <!--<label for="name"></label>-->
        <input type="password" required class="form-control" name="password" style="height: 55px;margin-top: 30px;"
               placeholder="请输入密码"><s:fielderror fieldName="password"></s:fielderror>
        <div style="height: 100px;width: 100%;margin-top: 30px;">
            <div style="float:left;width: 50%;padding: 20px;">
                <input type="submit" class="btn btn-primary" value="登陆"
                       style="margin:auto;width: 80%;height: 50px;padding: 13px;"></input>
            </div>
            <div style="float:right;width: 50%;padding: 20px;">
                <a href="/registjsp.action" type="button" class="btn btn-primary"
                   style="margin:auto;width: 80%;height: 50px;padding: 13px;">注册</a>
            </div>

        </div>

    </form>

</div>
</body>
</html>
