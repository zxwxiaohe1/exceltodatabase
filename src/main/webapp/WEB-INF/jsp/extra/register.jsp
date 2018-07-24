<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/extra/basepath.jsp"%>

<div id="regtu" class="regtu">
	<form id="thisForm" method="post"
		action="${pageContext.request.contextPath }/user/register.action">
		<table border="0" width="450px">
			<tr>
				<td height="50">
					<ul class="ul">
						<li>姓&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;名：</li>
					</ul>
				</td>
				<td align="left" align="center"><input type='text' name="name"
					id="name" /> <br />
					<div class="tipinfo" style="width: 50px; border: 0px red solid;"></div></td>
				<td class="tdcon" height="50" align="center">
					<ul class="ul2">
						<li>学&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;号：</li>
					</ul>
				</td>
				<td align="left"><input type="text" name="number" id="number" />
					<br />
					<div class="tipinfo" style="width: 60px; border: 0px red solid;"></div></td>
			</tr>
			<tr>
				<td class="tdcon" height="50">
					<ul class="ul">
						<li>登&nbsp;&nbsp;录&nbsp;&nbsp;名：</li>
					</ul>
				</td>
				<td align="left" align="center"><input type='text'
					name="loginname" id="loginname" /> <br />
					<div class="tipinfo" style="width: 50px; border: 0px red solid;"></div></td>
				<td class="tdcon" height="50">
					<ul class="ul">
						<li>密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码：</li>
					</ul>
				</td>
				<td align="left" align="center"><input type='text'
					name="password" id="password" /> <br />
					<div class="tipinfo" style="width: 50px; border: 0px red solid;"></div></td>
			</tr>
			<tr>
				<td class="tdcon" height="50">
					<ul class="ul">
						<li>年&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;龄：</li>
					</ul>
				</td>
				<td align="left" align="center"><input type='text' name="age"
					id="age" /> <br />
					<div class="tipinfo" style="width: 50px; border: 0px red solid;"></div></td>
			</tr>
		</table>
	</form>
</div>