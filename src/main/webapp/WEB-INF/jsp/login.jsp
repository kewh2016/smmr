<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title><spring:message code="login.user.login" /></title>
<%@ include file="common/resources.jsp"%>
<style type="text/css">
.center-vertical {
	width: 300px;
}

html, body {
	width: 100%;
	height: 100%;
	margin: 0;
	padding: 0;
}

body {
	display: flex;
	align-items: center; /*定义body的元素垂直居中*/
	justify-content: center; /*定义body的里的元素水平居中*/
}
</style>
</head>
<body>
	<div class="container center-vertical">
		<div class="row">
			<div class="col-md-12">
				<c:if test="${not empty error}">
					<div class="alert alert-danger">用户名或密码错误！</div>
				</c:if>
				<form action="${base}/login" method="post" role="form">
					<input name="target" value="${target}" type="hidden" />
					<div class="form-group">
						<label for="userNo"><spring:message code="login.user.name" /></label>
						<input name="userNo" type="text" id="userNo" class="form-control" />
					</div>
					<div class="form-group">
						<label for="password"><spring:message
								code="login.user.password" /></label> <input name="password"
							type="password" id="password" class="form-control" />
					</div>
					<input type="submit" class="btn btn-default"
						value="<spring:message code="login.user.submit"/>">
				</form>
			</div>
		</div>
	</div>
</body>
</html>