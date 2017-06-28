<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>角色授权</title>
</head>
<body>
	<div>
		<div>当前角色: ${role.roleName}</div>
		已有权限：
		<ul>
			<c:forEach items="${roleResources}" var="rr">
				<li>${rr.resourceName }|<a
					href="${base}/authority/remove?roleId=${role.id}&resourceId=${rr.resourceId}">移除权限</a></li>
			</c:forEach>
		</ul>
		不含权限：
		<ul>
			<c:forEach items="${resources}" var="r">
				<li>${r.resourceName }|<a
					href="${base}/authority/addallow?roleId=${role.id}&resourceId=${r.resourceId}">授权</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>