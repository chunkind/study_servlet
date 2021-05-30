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
	${ param.address }에 계신 ${ param.id }님의 가입을 환영합니다.<br>
	<a href="login.jsp">로그인 페이지로 이동</a><br>
	<a href="index.jsp">홈으로 이동</a><br>
</body>
</html>
