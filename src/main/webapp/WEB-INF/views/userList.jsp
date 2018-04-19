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
<style>
    .textbox{
        height: 20px;
        margin:0;
        padding:0 2px;
        box-sizing: content-box;
    }
</style>
<body>
    <table id="box" ></table>

    <div id="tb" style="padding: 5px">
        <div>
            <a class="easyui-linkbutton" href="#" iconCls="icon-add" plain="true">添加</a>
            <a class="easyui-linkbutton" href="#" iconCls="icon-remove" plain="true">删除</a>
            <a class="easyui-linkbutton" href="#" iconCls="icon-edit" plain="true">修改</a>
        </div>
        <div>
            查询账号:<input type="text" class="textbox" name="userName" style="width:110px">
            创建时间从:<input type="text" name="date_form" editable="false" class="easyui-datebox" style="width:110px">
            到:<input type="text" name="date_to" editable="false" class="easyui-datebox" style="width:110px">
            <a href="#" class="easyui-linkbutton" iconCls="icon-search">查询</a>
        </div>
    </div>


<script type="text/javascript">


    $(function () {
        $("#box").datagrid({
            url:"/user/list",
            width:800,
            title:"用户列表",
            emptyMsg: "还未创建用户信息",
            striped:true,    //斑马线
            fitColumns:true, //自适应宽度
            rownumbers:true,
            singleSelect:true,
            columns:[[
                {
                    field:"id",
                    width:100,
                    
                },
                {
                    field:"userName",
                    title:"用户名",
                    width:100,
                    sortable:'true'
                },
                {
                    field:"password",
                    title:"密码",
                    width:100
                },{
                    field:"rank",
                    title:"等级",
                    width:100,
                    sortable:'true'
                },{
                    field: 'id',
                    title: '操作',
                    width: 100,
                    align: 'center',
                    formatter: function (value, row, index) {
                        var str = '<button id="delete" class="easyui-linkbutton" value="'+row.id+'">删除</button>';
                        return str;
                    }
                },
            ]],
            pagination:'true',
            toolbar:'#tb'
        });
    });

    $(document).on("click","#delete",function(){
        confirm("确认删除?");
        $.ajax({
            type:'POST',
            url:'/user/delete?id='+this.value,
            success:function(result){
                if(result.code===1){
                    alert("删除成功!");
                    $("#box").datagrid("reload");
                } else
                    alert("删除失败!");
            },
            dataType:'json',
        })
    });



</script>
</body>
</html>
