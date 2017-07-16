<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件列表</title>
</head>
<body>
	<ol>
		<c:forEach items="${files}" var="file">
			<li><a href="${base}/load?path=${file.path}">${file.name}</a></li>
		</c:forEach>
	</ol>
</body>
</html>