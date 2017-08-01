<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<%@ include file="common/resources.jsp"%>
<style type="text/css">
.pull-left{width: 20%;margin: 0;padding: 0;}
.pull-right{width: 80%;margin: 0;padding: 0;}
#iframepage{width: 100%;border: none;}
</style>
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
	<div>
		<div class="pull-left panel panel-default">
			<a class="btn btn-warning" href="${base}/logout">注销</a>
			<ul id="menu" class="ztree"></ul>
		</div>
		<div class="pull-right">
			<iframe id="iframepage" name="iframepage"></iframe>
		</div>
	</div>
	<script type="text/javascript">
		window.onload=function(){
			var windowHeight = $(window).height()-6;
			console.log(windowHeight)
			$(".pull-left").height(windowHeight);
			$("#iframepage").height(windowHeight);
		}
	</script>
</body>
</html>