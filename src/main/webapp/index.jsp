<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/extra/basepath.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<script type="text/javascript" src="${ctxStatic}/js/easyUI/jquery-1.7.1.min.js"></script>
<link rel="stylesheet" type="text/css"
	href="${ctxStatic}/js/easyUI/themes/default/easyui.css">
<link rel="stylesheet" type="text/css" href="${ctxStatic}/js/easyUI/themes/icon.css">
<script type="text/javascript" src="${ctxStatic}/js/easyUI/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctxStatic}/js/verify/jquery.validate.js"></script>
<script type="text/javascript" src="${ctxStatic}/js/verify/validate_login.js"></script>
<link rel="stylesheet" type="text/css" href="${ctxStatic}/css/style/login.css">

</head>
<body>
	<div id="page" style="margin:100px 550px;">
		<div id="loginPanel" class="easyui-panel"
			style="width: 500px; height: 250px; padding: 10px;" title="用户登录"
			iconCls="icon-ok" tools="#tt">
			<form id="loginForm" method="post"
				action="${ctx}/user/login.action">
				<table id="table"width="350px" border="0" class="logintable">
					<tr>
						<td class="tdcon" height="50" align="left">
							<ul class="ul">
								<li>账&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;户:</li>
							</ul>
						</td>
						<td align="left" align="center"><input type='text'
							name="loginname" id="loginname" /> <br />
							<div class="tipinfo"></div></td>
					</tr>
					<tr>
						<td class="tdcon" height="50" align="left">
							<ul class="ul2">
								<li>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:</li>
							</ul>
						</td>
						<td align="left"><input type="password" name="password"
							id="password" /> <br />
							<div class="tipinfo"></div></td>
					</tr>
					<tr>
						<td align="center"><input type="submit" value="登录" /></td>
						<td align="center"><input type="reset" value="重置" /></td>
					</tr>
					<tr>
						<td align="left"><a href="register.jsp">找回密码</a></td>
						<td align="right"><a href="${ctx}/user/regist.action">注册</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>