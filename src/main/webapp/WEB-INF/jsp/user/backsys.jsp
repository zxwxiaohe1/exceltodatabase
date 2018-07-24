<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/extra/basepath.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>loginsuccess</title>
<!-- css -->
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/js/easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/js/easyUI/themes/icon.css">
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/js/easyUI/demo.css">
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/css/style/success.css">
<!-- js -->
<script type="text/javascript"
	src="${ctxStatic}/js/easyUI/jquery-1.7.1.min.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/js/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/js/verify/jquery.validate.js"></script>
<script type="text/javascript"
	src="${ctxStatic}/js/orgnal_js/userback.js"></script>
</head>
<script type="text/javascript">
	$(function() {
		userBack("${ctx}");
	});
</script>
<body class="easyui-layout">
	<div region="north" title="North Title" split="true"
		style="height: 100px; padding: 10px;">
		<p>The north content.</p>
	</div>
	<div region="south" title="South Title" split="true"
		style="height: 100px; padding: 10px; background: #efefef;">
	</div>
	<div region="east" iconCls="icon-reload" title="Tree Menu" split="true"
		style="width: 180px;">
		
	</div>
	<div region="west" split="true" title="West Menu"
		style="width: 280px; padding1: 1px; overflow: hidden;">
		<div class="easyui-accordion" fit="true" border="false">
			<div title="系统管理" style="padding: 10px; overflow: auto;">
				<p>
					<a href="#" class="userpower" icon="icon-add">用户用户</a>
				</p>
				<p>
					<a href="#" class="powerchange" icon="icon-add">角色列表</a>
				</p>
				<p>
					<a href="#" class="powerchange" icon="icon-add">部门列表</a>
				</p>
				<p>
					<a href="#" class="powerchange" icon="icon-add">资源列表</a>
				</p>
				<p>
					<a href="#" class="powerchange" icon="icon-add">参数配置</a>
				</p>
			</div>
			<div title="部门管理" selected="true" style="padding: 10px;">
				<p>
					<a href="#" class="userpower" icon="icon-add">用户用户</a>
				</p>
				<p>
					<a href="#" class="powerchange" icon="icon-add">角色列表</a>
				</p>
				<p>
					<a href="#" class="powerchange" icon="icon-add">部门列表</a>
				</p>
				<p>
					<a href="#" class="powerchange" icon="icon-add">资源列表</a>
				</p>
				<p>
					<a href="#" class="powerchange" icon="icon-add">参数配置</a>
				</p>
			</div>
			<div title="权限管理" style="padding: 10px">
				<p>
					<a href="#" class="userpower" icon="icon-add">用户用户</a>
				</p>
				<p>
					<a href="#" class="powerchange" icon="icon-add">角色列表</a>
				</p>
				<p>
					<a href="#" class="powerchange" icon="icon-add">部门列表</a>
				</p>
				<p>
					<a href="#" class="powerchange" icon="icon-add">资源列表</a>
				</p>
				<p>
					<a href="#" class="powerchange" icon="icon-add">参数配置</a>
				</p>>
			</div>
		</div>
	</div>
	<div region="center" title="信息导航" style="overflow: hidden;">
		<div id="tt" class="easyui-tabs" fit="true" border="false"></div>
	</div>
</body>
</html>