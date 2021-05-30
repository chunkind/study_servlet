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
<c:catch var="e">
	<c:set var="num1" value="${param.num1}" />
	<c:set var="num2" value="${param.num2}" />
	NUM1 :: ${num1}<br>
	NUM2 :: ${num2}<br><hr>
	
	1.EL을 이용한 나눗셈의 결과는 :: ${num1/num2}
</c:catch>
<c:if test="${e != null }">
	에러 메세지 :: ${e.message}
</c:if>
</body>
</html>