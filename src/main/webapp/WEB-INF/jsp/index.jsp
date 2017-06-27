<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<%@ include file="common/resources.jsp"%>
</head>
<body>
	<script type="text/javascript">
		var setting = {
			data : {
				simpleData : {
					enable : true
				}
			}
		};
		var zNodes = $.parseJSON('${menu}');
		$(document).ready(function() {
			$.fn.zTree.init($("#menu"), setting, zNodes);
		});
	</script>
	<a href="${base}/logout">注销</a>
	<div class="zTreeDemoBackground left"
		style="width: 15%; float: left; position: fixed;">
		<ul id="menu" class="ztree"></ul>
	</div>
	<div class="right">
		<iframe id="iframepage" name="iframepage"
			style="width: 80%; height: 700px; position: fixed; top: 0; right: 0"></iframe>
	</div>
</body>
</html>