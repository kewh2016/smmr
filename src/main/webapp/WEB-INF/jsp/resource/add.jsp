<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户</title>
</head>
<body>
	<form action="${base}/user/add" method="post">
		<table>
			<tr>
				<td>用户号</td>
				<td><input name="userNo"></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input name="password" type="password"></td>
			</tr>
			<tr>
				<td>角色</td>
				<td><select name="roleId">
						<c:forEach items="${roles}" var="role">
							<option value="${role.id }">${role.roleName}</option>
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