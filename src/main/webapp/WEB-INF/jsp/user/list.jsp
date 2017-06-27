<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户列表</title>
</head>
<body>
	<ul>
		<c:forEach items="${users}" var="user">
			<li>${user.userNo}|<c:forEach items="${roles}" var="role">
					<c:if test="${role.id eq user.roleId }">${role.roleName }</c:if>
				</c:forEach></li>
		</c:forEach>
	</ul>
</body>
</html>