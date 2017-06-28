<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加资源</title>
</head>
<body>
	<form action="${base}/resource/add" method="post">
		<table>
			<tr>
				<td>资源名称</td>
				<td><input name="resourceName"></td>
			</tr>
			<tr>
				<td>资源URL</td>
				<td><input name="resourceUrl"></td>
			</tr>
			<tr>
				<td>资源类型</td>
				<td><select name="type">
						<option value="1">菜单</option>
						<option value="2">操作</option>
				</select></td>
			</tr>
			<tr>
				<td>上级资源</td>
				<td><select name="parentId">
						<option value="">无上级</option>
						<c:forEach items="${resources}" var="resource">
							<option value="${resource.id}">${resource.resourceName}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>
</body>
</html>