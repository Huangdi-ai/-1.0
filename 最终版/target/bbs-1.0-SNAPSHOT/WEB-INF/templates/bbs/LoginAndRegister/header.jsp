<%--
  Created by IntelliJ IDEA.
  User: 15718
  Date: 2019/7/7
  Time: 8:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link href="../../../../static/bbs/css/bootstrap.min.css" rel="stylesheet">
    <link href="../../../../static/bbs/css/titlebar.css" rel="stylesheet">
    <script src="../../../../static/bbs/js/jquery.min.js"></script>
    <script src="../../../../static/bbs/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse" role="navigation">
    <div class="navbar-header">
<<<<<<< HEAD
        <a class="navbar-brand" href="#">BBS技术论坛</a>
=======
        <a class="navbar-brand" href="/index.action">BBS技术论坛</a>
>>>>>>> 7ac47f9ab9c6762e51ebe27ab6668fa5c6a86344
    </div>

    <div>
        <ul class="nav navbar-nav">
<<<<<<< HEAD
            <li><a href="/index.jsp">首页</a></li>
=======
            <li><a href="/index.action">首页</a></li>
>>>>>>> 7ac47f9ab9c6762e51ebe27ab6668fa5c6a86344
            <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    精选板块 <b class="caret"></b>
                </a>

                <ul class="dropdown-menu">

                    <li th:each="mainforum:${mainforumList}">
                        <ul style="margin: 0%;padding: 0%"><li class="divider"></li></ul>
                        <a href="/more.action?type=id&&page=1" th:text="${mainforum.title}" ></a>
                    </li>
                </ul>

            </li>
            <li><a href="<%=request.getContextPath() %>/more.action?type=-3&&page=1">论坛热帖</a></li>
            <li><a href="<%=request.getContextPath() %>/more.action?type=-1&&page=1">论坛新帖</a></li>
            <li><a href="<%=request.getContextPath() %>/more.action?type=-2&&page=1">精华帖</a></li>
        </ul>
    </div>
    <form class="navbar-form navbar-right" role="search" action="<%=request.getContextPath()%>/search.action">
        <div class="input-group">
            <input type="text" class="form-control" name="keywords" placeholder="search">
            <span class="input-group-addon"><span class="glyphicon glyphicon-search"></span> </span>
        </div>
    </form>
</nav>
</body>
</html>