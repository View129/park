<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="/resources/css/login.css">
    <link rel="stylesheet" href="/resources/font-awesome/css/font-awesome.min.css">
</head>
<body>

<div class="logo_box">
    <h1>车辆管理系统</h1>
    <form action="login" method="post" autocomplete="off">

        <div class="input_outer">
            <i class="fa fa-user-o u_user"></i>
            <input required="required" name="userName" class="text" placeholder="输入账号" type="text">
        </div>

        <div class="input_outer">
            <i class="fa fa-eye u_user"></i>
            <input required="required" placeholder="请输入密码" name="password" class="text" type="password">
        </div>

        <div class="mb2">
            <button class="act-but submit" style="color: #FFFFFF">登录</button>
            <div class="actions"><a href="/reg">注册</a></div>
        </div>


    </form>
</div>
</body>
</html>
