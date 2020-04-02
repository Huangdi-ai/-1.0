<%--
  Created by IntelliJ IDEA.
  User: 11251
  Date: 2019/7/8
  Time: 16:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%@ page import="com.common.pojo.User"%>


<html>
<head>
    <title>Title</title>
</head>
<body>
<jsp:include page="/WEB-INF/templates/bbs/LoginAndRegister/header.jsp"/>
<%
    request.setCharacterEncoding("utf8");
    HttpSession session1=request.getSession();
    /*if (session1.getAttribute("username")==null&session1.getAttribute("password")==null)
    {
        response.sendRedirect("loginjsp.action");
    }
    String k = request.getParameter("name");
    //UserDaoImpl userdaoimpl=new UserDaoImpl();
    //int p=userdaoimpl.getUserIdByUsername(k);*/
%>
<h1>更改资料</h1><hr>
<div class="container" style="margin-top: 30px">
    <div class="row">
        <div class="col-xs-3">
            <ul class="nav nav-pills nav-stacked">
                <li role="presentation" class="active"><a href="#">资料修改</a></li>
                <li role="presentation"><a href="#">我的帖子</a></li>
                <li role="presentation"><a href="#">申请记录</a></li>
            </ul>

        </div>
<%
    int userid= (int) session1.getAttribute("userId");
    System.out.println(userid);
    //int postId=Integer.parseInt(userid);
%>
        <div class="col-xs-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">
                        个人信息修改
                    </h3>
                </div>
                <div class="panel-body">

                    <form id="form1" action="/change.action" method="post" enctype="multipart/form-data">

                    <form id="form1" action="/change.action" method="post">




                        <div class="form-group">
                            <label for="name">用户名</label>
                            <input id="username" type="text" class="form-control" name="username" id="name" width="200px" height="80px" value=""
                            <input id="username"  type="text" class="form-control" name="username" id="name" width="200px" height="80px" value=""
                                   placeholder="请输入名称"> <p class="help-block"><s:fielderror fieldName="username"></s:fielderror></p>
                        </div>

                        <div class="form-group">
                            <label for="name">性 别</label><br/>

                            男<input type="radio" name="sex" value="男" checked="checked">
                            &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp女<input type="radio" name="sex" value="女">



                        </div>


                        <dl class="form-group">
                            <dt><label for="user_profile_blog">邮箱</label></dt>
                            <dd><input id="email" type="email" class="form-control" id="user_profile_blog" name="email" size="30" value="" />
                                <p class="help-block"><s:fielderror fieldName="email"></s:fielderror></p>
                            </dd>
                        </dl>
                        <dl class="form-group">
                            <dt>密码</dt>
                            <dd><input class="form-control" id="password" name="password" size="30" type="password" width="200px" /></dd>
                        </dl>
                        <dl class="form-group">
                            <dt>重复密码</dt>
                            <dd><input class="form-control" id="confirm_password" name="confirm_password" size="30" type="password" width="200px" /></dd>
                        </dl>
                        <input type="submit" value="提交"> <s:fielderror fieldName="update-result"></s:fielderror>
                        <input type="hidden" name="postId" value="<%=userid%>">
                    </form>
                </div>
            </div>




        </div>
    </div>
</div>
</body>
</html>
