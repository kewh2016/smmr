<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<%@ include file="common/resources.jsp"%>
</head>
<body>
	<div style="margin: 300px auto;width: 300px;">
		<form action="${base}/login" method="post">
			<table>
				<tr>
					<td>用户号</td>
					<td><input name="userNo" type="text"/></td>
				</tr>
				<tr>
					<td>密码</td>
					<td><input name="password" type="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>