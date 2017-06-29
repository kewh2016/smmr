<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="login.user.login"/></title>
<%@ include file="common/resources.jsp"%>
</head>
<body>
	<div style="margin: 300px auto;width: 300px;">
		<form action="${base}/login" method="post">
			<table>
				<tr>
					<td><spring:message code="login.user.name"/></td>
					<td><input name="userNo" type="text"/></td>
				</tr>
				<tr>
					<td><spring:message code="login.user.password"/></td>
					<td><input name="password" type="password" /></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="<spring:message code="login.user.submit"/>"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>