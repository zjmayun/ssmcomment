<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>上传图片测试</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/person/addUser" method="post" enctype="multipart/form-data">
		用户名：<input type = "text"  name = "name" /><br>
		图片： <input type="file"     name = "file" /><br>
			<input type = "submit" value = "提交">
	</form>
    
</body>
</html>