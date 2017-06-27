<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色列表</title>
</head>
<body>
	<ul>
		<c:forEach items="${roles}" var="role">
			<li>${role.roleName}</li>
		</c:forEach>
	</ul>
</body>
</html>