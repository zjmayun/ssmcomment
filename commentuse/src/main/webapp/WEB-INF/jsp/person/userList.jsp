<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>测试图片回显</title>
</head>
<body>
<c:forEach items="${personList}" var="userList" >
	${userList.name}<br><br><br><br>
	<!--拼接图片回显的的URL-->
	<img src="http://localhost:8080/commentuse/${userList.imgUrl}" 
	width="300" height="300"><br><br><br><br>
</c:forEach>
</body>
</html>