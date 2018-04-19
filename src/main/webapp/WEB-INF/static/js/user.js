$(function(){

	obj = {
		search : function (){ //查询功能
			alert(2)
			$('#box').datagrid('load',{
				userName : $.trim($("input[name='userName']").val()),
			});
		},
	};

	$("#box").datagrid({
		//width:100,
		url : '/user/list',
		title:'管理员列表',
		iconCls : 'icon-search',
		striped : true,//斑马线效果
		fitColumns : true,//列自适应大小
		rownumbers : true,//显示行号
		singleSelect : true,// 显示行号
		columns : [[
            {
                field : 'id',
                title : '账号',
				//checkbox : true,
            },
			{
				field : 'userName',
				title : '账号',
				sortable : true, //排序
				//align: 'center',//标题内容居中
				halign : 'center',//标题居中
				width : 100,//100%
			},
			{
				field : 'password',
				title : '密码',
				sortable : true,
                halign : 'center',//标题居中
				width : 100,//100%

			},
			{
				field : 'rank',
				title : '权限',
				sortable : true,
                halign : 'center',//标题居中
				width : 100,//100%

			},
		]],
		toolbar : '#tb',
		pagination : true, //底部显示分页组件
		sortName : 'id',// 允许排序的列（第一次加载）
		sortOrder : 'asc',//排序规则（第一次加载）
        remoteSort : false //定义是否服务器排序
	});
});