/**
 * @author Administrator
 */
$(function() {
	initValidator();
	$("#number").blur(function() {
		var num = $("#number").val();
		if (num == "") {
			faild("学号不能为空");
		} else {
			$.ajax({
				url : "/exceltodatabase/user/responseJson.action",
				type : "post",
				data : "number=" + num,
				success : function(data) {
					if (data.trim() != "0") {
						faild("已存在学号");// 学号可用示样式函数
					} else {
						suc();// 学号可用提示样式函数
					}
				}
			});
		}

	});
});

function suc() {
	$("#number")
			.siblings(".tipinfo")
			.html("")
			.css(
					{
						"background" : "url('/exceltodatabase/views/css/images/validate/checked.gif') no-repeat left",
						"height" : "13px",
						"width" : "20px",
						"overflow" : "hidden",
						"padding" : "0",
						"display" : "inline-block",
					});
}
function faild(str) {
	$("#number")
			.siblings(".tipinfo")
			.html(str)
			.css(
					{
						"background" : "url('/exceltodatabase/views/css/images/validate/unchecked.jpg') no-repeat left",
						"color" : "red",
						"padding-left" : "20px",
						"width" : "50px",
						"padding-top" : "0",
						"display" : "block"
					});
}
function initValidator(base) {
	$("#thisForm").validate({
		onkeyup : false,
		// 设置验证规则
		rules : {
			"name" : {
				required : true,
				stringCheck : true,
			},
			"number" : {
				required : !$("#number").html() == null ? true : false,
			},
			"loginname" : {
				required : true,
				stringCheck : true,
			},
			"password" : {
				required : true,
				rangelength : [ 6, 12 ],
			},
			"age" : {
				required : true,
			},
		},
		// 设置错误信息
		messages : {
			"name" : {
				required : "请输入姓名",
				stringCheck : "只能包括中文字、英文字母",
			},
			"number" : {
				required : "请输入学号",
			},
			"loginname" : {
				required : "请输入登录名",
				stringCheck : "只能包括中文字、英文字母",
			},
			"password" : {
				required : "请输入密码",
			},
			"age" : {
				required : "请输入年龄",
			},
		},
		errorElement : "font",
		errorPlacement : function(error, element) {
			// error.appendTo(element.parent().find(".tipinfo"));
			element.parent().find(".tipinfo").removeAttr("style").html(error);
		},
		success : "valid"
	});
}
