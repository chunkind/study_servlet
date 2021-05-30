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
<h2>오늘의 점심 메뉴입니다..</h2><p>
1. EL을 이용해서 출력 :: ${arr[0]}, ${arr[1]}, ${arr[2]}, ${arr[3]}, ${arr[4]}, ${arr[5]} <br><hr>
2. JSTL을 이용해서 출력::
<ul>
<c:forEach var="dish" items="${arr}">
	<li>${dish}</li>
</c:forEach>
</ul>
</body>
</html>