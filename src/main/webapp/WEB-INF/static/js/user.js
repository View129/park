$(function(){

	obj = {
		editrow : undefined,//添加的标记变量
		search : function (){$('#box').datagrid('load',{
				userName : $.trim($("input[name='userName']").val()),
				rank : $.trim($("input[name='rank']").val()),
			});
		},
		add : function (){ //添加功能
			if(this.editrow==undefined){
				$('#save,#redo').show();
				$('#box').datagrid('insertRow',{
				index :0,
				row :{ //设默认值

				},
			});
			//将第一行设置为可编辑状态
			$('#box').datagrid('beginEdit',0);
			this.editrow=0;
			}else{
				$.messager.show({
					title : '提示',
					msg : '请先取消编辑',
				});

			}	
		},
		save : function (){
			//结束编辑状态 自动触发onAfterEdit事件
			$('#box').datagrid('endEdit',this.editrow);

		},
		redo : function (){
			$('#save,#redo').hide();
			this.editrow=undefined;
			$('#box').datagrid('rejectChanges');//回滚所有从创建或者上一次调用acceptChanges函数后更改的数据
		},
		edit : function (){
			var rows = $('#box').datagrid('getSelections');//获取选中的行
			if(rows.length == 1){
					if(obj.editrow!=undefined){
	        		$('#box').datagrid('endEdit',obj.editrow);
	        	}
	        	if(obj.editrow == undefined){
	        		var index = $('#box').datagrid('getRowIndex',rows[0]);//获取选中行的行号
	        		$('#save,#redo').show();
	        		$('#box').datagrid('beginEdit',index);
	        		obj.editrow=index;
	        		$('#box').datagrid('unselectRow',index);
	        	}
			}else{
				$.messager.alert('警告','修改必须且只能选择一行');
			}
			
		},
		remove : function (){
			var rows = $('#box').datagrid('getSelections');//获取选中的行
			if(rows.length>0){
				$.messager.confirm('确定操作','你确定要删除所选记录吗？',function (flag){
					if(flag){
						list={list:JSON.stringify(rows)};
						console.log(list);
						$.ajax({
							type : 'POST',
							url : '/user/delete',
							data : list,
							beforeSend : function(){
								$('#box').datagrid('loading');//载入动画
							},
							success : function (data){
								$('#box').datagrid('loaded');//关闭载入动画
								$('#box').datagrid('load');
								$('#box').datagrid('unselectAll');//取消所有选中
								if(data.code===0){
									$.messager.show({
									title : '提示',
									msg : '删除失败',
								});
								}else{
									$.messager.show({
									title : '提示',
									msg : '删除成功',
								});
								}
							},
							dataType: "json",
						});
					}
				});
			}else{
				$.messager.alert('提示','请选择要删除的行','info');
			}
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
		//singleSelect : true,// 允许选着多行
		columns : [[
            {
                field : 'id',
                title : 'id',
				checkbox : true,
            },
			{
				field : 'userName',
				title : '账号',
				sortable : true, //排序
				//align: 'center',//标题内容居中
				halign : 'center',//标题居中
				width : 100,//100%
				editor : {  //编辑
					type : 'validatebox',
					options : {
							required :"true",
					},
				},
			},
			{
				field : 'password',
				title : '密码',
				sortable : true,
                halign : 'center',//标题居中
				width : 100,//100%
				editor : {  //编辑
					type : 'validatebox',
					options : {
							required :"true",
					},
				},

			},
			{
				field : 'rank',
				title : '权限',
				sortable : true,
                halign : 'center',//标题居中
				width : 100,//100%
				editor : {  //编辑
					type : 'validatebox',
					options : {
							required :"true",
					},
				},

			},
		]],
		toolbar : '#tb',
		pagination : true, //底部显示分页组件
		sortName : 'id',// 允许排序的列（第一次加载）
		sortOrder : 'asc',//排序规则（第一次加载）
        remoteSort : false, //定义是否服务器排序
        onDblClickRow : function (rowIndex,rowData){//双击一行
        	if(obj.editrow!=undefined){
        		$('#box').datagrid('endEdit',obj.editrow);
        	}
        	if(obj.editrow == undefined){
        		$('#save,#redo').show();
        		$('#box').datagrid('beginEdit',rowIndex);
        		obj.editrow=rowIndex;
        	}
        	
        },
        onAfterEdit : function(rowIndex,rowData,changes){ //在用户完成编辑一行的时候触发
        	
        	var msg;
        	var inserted = $('#box').datagrid('getChanges','inserted');
        	var update = $('#box').datagrid('getChanges','update');
        	if(inserted.length>0){//新增
        		msg="新增";
        	}else{
        		msg="保存之前修改";
        	}

        	$.messager.confirm('确定操作','你确定要'+msg+'吗？',function (flag){
        		$('#save,#redo').hide();
        		obj.editrow=undefined;
					if(flag){
						$.ajax({
							type : 'POST',
							url : '/user/insert',
							data : rowData,
							beforeSend : function(){
								$('#box').datagrid('loading');//载入动画
							},
							success : function (data){
								$('#box').datagrid('loaded');
								$('#box').datagrid('load');
								$('#box').datagrid('unselectAll');//取消所有选中
								if(data&&data.code===1){
									$.messager.show({
									title : '提示',
									msg : msg+'成功',
								});
								}else{
									$.messager.show({
									title : '提示',
									msg : msg+'失败',
								});
								}
							},
							dataType: "json",
						});
					} else{
						$('#box').datagrid('load');
						$('#box').datagrid('unselectAll');//取消所有选中
					}
				});
			
			console.log(rowData);

        },
	});
});