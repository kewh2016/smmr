<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>权限列表</title>
</head>
<body>
	<div>
		<ul>
			<c:forEach items="${roleResources}" var="rr">
				<li>${rr.roleName }|${rr.resourceName }</li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>