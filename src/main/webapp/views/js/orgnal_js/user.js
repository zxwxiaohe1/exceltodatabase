/**
 * @author Administrator
 */

// data展示用户信息
function datagrid(ctx) {
	var addRows = true;
	
	$('#test').datagrid({
		title : '用户信息',
		iconCls : 'icon-save',
		url : ctx + '/user/userlist.action',
		method : 'POST',
		width : 1000,
		rownumbers : true,
		striped : true,// 是否显示斑马线效果
		collapsible : true,
		sortName : 'uid',// 定义哪些列可以进行排序
		sortOrder : 'desc',// 定义列的排序顺序
		remoteSort : false,// 定义从服务器对数据进行排序
		idField : 'uid',// 指明哪个字段为标识字段
		toolbar : [ {
			id : 'btnadd',
			text : '添加用户',
			iconCls : 'icon-add',
			handler : function() {
				$('#btsave').show();// 隐藏保存按钮
				addUser();// 调用添加函数
			}
		}, {
			id : 'btndelete',
			text : '删除用户',
			iconCls : 'icon-cancel',
			handler : function() {
				deleteUser(ctx);// 调用删除用户
			}
		}, {
			id : 'btsave',
			text : '保存',
			iconCls : 'icon-save',
			handler : function() {
				alert("点击了保存");
				$('#test').datagrid('endEdit', 0);
				// deleteUser(ctx);// 调用删除用户
			},
		} ],
		columns : [ [ {
			field : 'id',
			title : '编号',
			sortable : true,
			width : 100,
			checkbox : true,
		}, {
			field : 'uid',
			title : '用户ID',
			hidden : true,
		}, {
			field : 'name',
			title : '用户名',
			width : 180,
			editor : {
				type : 'validatebox',
				options : {
					required : true,
				},

			},
		}, {
			field : 'number',
			title : '工号',
			width : 180,
			editor : {
				type : 'validatebox',
				options : {
					required : true,
				},

			},
		}, {
			field : 'loginname',
			title : '登录名',
			width : 180,
			editor : {
				type : 'validatebox',
				options : {
					required : true,
				},

			},
		}, {
			field : 'age',
			title : '年龄',
			width : 180,
			editor : {
				type : 'validatebox',
				options : {
					required : true,
				},

			},
		}, {
			id:"photo",
			title:'图片',
			field:'image',
			width:100,
			align:'left',
	        formatter:function(value,row,index){return '<a href="" class="edit"><img src="'+ctx+'/views/js/easyUI/themes/icons/search.png" /></a>';},
		    handler : function() {
			alert("点击了图片");
		}
		},

		] ],
		pagination : true,
		pageSize : 15,
		pageList : [ 12, 24, 36 ],
		pageNumber : 1,
		pagePosition : 'bottom',
		onAfterEdit : function(rowIndex, rowData, changes) {
			saveUser(rowData);// 向服务器端传输数据，新增用户

		},
	});
	$('#btsave').hide();
	// dialog添加一行用户表格
	function addUser() {
		// 添加一行
		if (addRows) {
			$('#test').datagrid('insertRow', {
				index : 0,
				row : {
				// height : 30,
				},
			});
			// 将第一行设置为可编辑状态
			$('#test').datagrid('beginEdit', 0);
			addRows = false;
		}

	}
	// 向服务器端传输数据，新增用户
	function saveUser(rowData) {
		addRows = true;
		$('#btsave').hide();
		$.ajax({
			url : ctx + '/user/register.action',// 提交的地址
			type : "post",// 提交的方式
			data : {
				name : rowData["name"],
				number : rowData["number"],
				loginname : rowData["loginname"],
				age : rowData["age"],
			},// 提交的参数
			success : function(data) {
				$('#test').datagrid('load');
				$.messager.confirm('提示', '新增用户成功！');
			}
		});
	}

	// 删除用户
	function deleteUser(ctx) {
		var rows = $('#test').datagrid("getSelections");

		if (rows == 0) {
			$.messager.confirm('提示', '请选择删除行！');
		} else {
			var uids = [];
			var copyRows = [];
			for (var j = 0; j < rows.length; j++) {
				copyRows.push(rows[j]);
				uids.push(rows[j].uid);
			}
			$.messager.confirm('提示', '确定要删除选中数据？', function(flag) {
				if (flag) {
					$.ajax({
						url : ctx + '/user/deleteUser.action',// 提交的地址
						type : "post",// 提交的方式
						data : {
							uids : uids.join(','),
						},// 提交的参数
						success : function(data) {
							$('#test').datagrid('load');
							$('#test').datagrid('unselectAll');
						}
					});
				}
			});

		}
	}
}