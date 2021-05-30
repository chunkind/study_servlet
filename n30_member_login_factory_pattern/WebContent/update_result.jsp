<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	Succeed in updating.<br>
	Your changed Information<br>
	ID : ${ param.id }<br>
	Name : ${ param.name }<br>
	Updated Password : ${ param.password }<br>
	Updated address : ${ param.address }<br>
	<a href="index.jsp">Move to Home page</a>
</body>
</html>
