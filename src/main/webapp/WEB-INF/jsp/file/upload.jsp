<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>文件上传</title>
</head>
<body>
	<form action="${base}/upload" method="post" enctype="multipart/form-data">
		<input type="file" name="file" /> <input type="submit" value="提交" />
	</form>
</body>
</html>