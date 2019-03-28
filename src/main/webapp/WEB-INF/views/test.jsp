<%--
  Created by IntelliJ IDEA.
  User: chen
  Date: 2019/3/20
  Time: 11:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录界面</title>
</head>
<body>
    <div>
        <input name="username" placeholder="用户名" type="text"
         id="userName"><br>
        <input name="password" placeholder="密码" type="password"
               id="password"><br>
        <input value="登录"
               type="button" id="loginBtn">
    </div>
</body>
<script type="text/javascript" src="3rd/jquery-2.1.4.js"></script>
<script type="text/javascript">
    $("#loginBtn").click(function() {
        var userName = $("#userName").val();
        var password = $("#password").val();
        if(userName==""||password==""){
            alert("不能为空");
        }else{
        $.ajax({
            url : "login.ajax",
            type : "post",
            data : {
                userName : userName,
                password : password
            },
            dataType : "json",
            success : function(respData) {
                if (respData.login == "true") {
                    alert("登陆成功");
                }else{
                    alert("登陆失败");
                }
            },
            error : function(err) {
                alert("出错");
            }
        });}
    })
</script>
</html>
