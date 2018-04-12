<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息显示</title>
    <script type="text/javascript" src="/resources/easyui/jquery.min.js"></script>
    <!-- 2    css资源 -->
    <link rel="stylesheet" type="text/css" href="/resources/easyui/themes/default/easyui.css">
    <!-- 3    图标资源 -->
    <link rel="stylesheet" type="text/css" href="/resources/easyui/themes/icon.css">
    <!-- 4    EasyUI的js包 -->
    <script type="text/javascript" src="/resources/easyui/jquery.easyui.min.js"></script>
    <!-- 5    本地语言 -->
    <script type="text/javascript" src="/resources/easyui/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>
<table id="tb_user">
</table>

<script type="text/javascript">
    $(function () {
        $("#tb_user").datagrid({
                url:"user/list",
                fitColumns:true,
                fit: true,
                columns:[[
                    {field:'ck',checkbox:true},
                    {field:"id",title:"编号",width:100},
                    {filed:"password",title:"用户名",width:200},
                    {field:"rank",title:"密码",width:200},
                    {filed:"userName",title:"等级",width:200}
                ]]
            });
    })
</script>
</body>
</html>
