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
    <link href="../../../../static/bbs/css/regist.css" rel="stylesheet">
    <script src="../../../../static/bbs/js/jquery.min.js"></script>

    <script type="text/javascript">
        function validate(f) {
            if(f.name.value==null|f.name.value==""){
                alert("请输入用户名")
                f.name.focus();
                return false;
            }
            if(f.password.value==null|f.password.value==""){
                alert("请输入密码")
                f.password.focus();
                return false;
            }
            if(f.repassword.value!=f.password.value){
                alert("两次密码不一致!!")
                f.repassword.focus();
                return false;
            }
            return true;
        }
    </script>

</head>
<body>
<jsp:include page="/WEB-INF/templates/bbs/LoginAndRegister/header.jsp"/>
<div class="regist">
    <form id="form1" role="form" action="/regist.action" method="post">
        <!--<label for="name">用户名:</label>-->
        <input id="username" type="text" class="form-control" name="username" style="height: 40px; margin-top: 20px;"
               placeholder="请输入用户名"><s:fielderror fieldName="username"></s:fielderror>
        <!--<label for="name"></label>-->
        <input id="password" type="password" class="form-control" name="password" style="height: 40px;margin-top: 20px;"
               placeholder="请输入密码"><s:fielderror fieldName="password"></s:fielderror>


        <input id="confirm_password" type="password" class="form-control" name="password" style="height: 40px;margin-top: 20px;"
               placeholder="请重复密码">

        <div style="margin-top: 10px;margin-left: 10px;">
            <div style="float: left;margin-bottom: 10px">性别:</div>
            <div style="float:left;margin-left: 100px;margin-bottom: 10px">
                男<input type="radio" name="sex" value="男">
            </div>
            <div style="float: right;margin-right: 100px;margin-bottom: 10px">
                女<input type="radio" name="sex" value="女">
            </div>
        </div>
       <%-- 这里手机号就是邮箱--%>
        <input id="userPhone" type="text" value="" class="form-control" name="email" style="height: 40px;margin-top: 20px;"
               placeholder="请输入手机号">
        <div style="display: flex; flex-direction: row;">
        <input  type="text" class="form-control" name="volidcode" style="height: 40px;margin-top: 20px;width: 150px"
               placeholder="请输入验证码">
        <span style="padding-top: 30px; padding-left: 10px;" onclick="sendSMS()">发送短信验证码</span>
        </div>
        <div style="height: 80px;width: 100%;margin-top: 20px;margin-left: 30px;">
            <!--<div style="float:left;width: 100%;padding: 20px;">-->
            <input type="submit" class="btn btn-primary" value="注册"
                   style="margin:auto;width: 80%;height: 40px;padding: 10px;"></input>
            <!--</div>-->


        </div>

    </form>


</div>
<script>
    function sendSMS(){
        alert(document.getElementById("userPhone").value)
        $.ajax({
            type: 'POST',
            url: '/Aliyunmessage.action',
            data:{"phone":document.getElementById("userPhone").value},
            dataType: 'json',
            success: function(data){
               alert("验证码以发送到你的手机上")
               // location.replace(location.href);
            },
            error:function(data) {
                alert("error")
                //console.log(data.msg);
                console.log(data);
            },
        });
    }
</script>
</body>
</html>