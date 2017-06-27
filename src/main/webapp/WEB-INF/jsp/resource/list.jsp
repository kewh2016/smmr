<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>资源列表</title>
</head>
<body>
	<ul>
		<c:forEach items="${resources}" var="resource">
			<li>${resource.resourceName}|${resource.resourceUrl}</li>
		</c:forEach>
	</ul>
</body>
</html>