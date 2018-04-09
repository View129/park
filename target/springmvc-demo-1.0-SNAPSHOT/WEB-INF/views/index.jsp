<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/3/30 0030
  Time: 9:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>我系渣渣辉!</h1>
    <form action="/user/getUser" method="post">
        用户名:
        <input type="text" name="username"/><br>
        <%--密码:--%>
        <%--<input type="password" name="password"/><br>--%>
        <%--年龄:--%>
        <%--<input type="text" name="age"/><br>--%>
        <input type="submit" value="提交">
    </form>

</body>
</html>
