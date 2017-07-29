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
	<form action="${base}/upload" method="post"
		enctype="multipart/form-data">
		<input type="file" name="file" id="file" accept="image/*" onchange="readAsDataURL()"/> <input disabled="disabled" id="submit" type="submit" value="提交" />
	</form>
	<div id="result"></div>
	<script type="text/javascript">
		if (typeof FileReader == 'undefined') {
			result.innerHTML = "抱歉，你的浏览器不支持FileReader";
		}
		// 将文件以Data URL形式进行读入页面
		function readAsDataURL() {
			var result = document.getElementById("result");
			// 检查是否为图像类型
			var simpleFile = document.getElementById("file").files[0];
			if (!/image\/\w+/.test(simpleFile.type)) {
				alert("请确保文件类型为图像类型");
				return false;
			}
			var reader = new FileReader();
			// 将文件以Data URL形式进行读入页面
			reader.readAsDataURL(simpleFile);
			reader.onload = function(e) {
				console.log(this.result);
				document.getElementById("submit").removeAttribute("disabled");
				result.innerHTML = '<img src="'+this.result+'" alt=""/>';
			}
		}
	</script>
</body>
</html>