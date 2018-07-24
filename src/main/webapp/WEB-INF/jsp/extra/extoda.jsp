<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ page isELIgnored="false"%>
<html>
<head>
<title>success.jsp</title>
</head>
<body>
	<p>${userList}</p>
	<c:if test="${userList=='failed'}">
数据库数据是最新数据,Excel无数据变化
</c:if>
	<c:if test="${userList=='success'}">
数据导入成功！
</c:if>
</body>
</html>