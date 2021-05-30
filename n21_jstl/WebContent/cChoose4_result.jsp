<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:choose를 이용한 제어문 사용법.</title>
</head>
<body>
<c:choose>
	<c:when test="${param.num1 == 0}">
		 좋은 아침 입니다..반가워요
	</c:when>
	<c:when test="${param.num1==1}">
		오랜만입니다.. 건강하시지요?
	</c:when>
	<c:otherwise>
		모르는 사람입니다..현대백화점.
	</c:otherwise>
</c:choose>
</body>
</html>