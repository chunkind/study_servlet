<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Include jsp file..Using Directive Element</h2>
<h1>오늘의 메뉴</h1><p>
<ul>
	<li>순대국밥</li>
	<li>김치 볶음밥</li>
	<li>김밥</li>
</ul>
<%@ include file="directive4_include.jsp" %>
</body>
</html>