<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 
		num1이라는 변수선언, 7값 할당.
		num2이라는 변수선언, 9값 할당.
 --%>
<c:set var="num1" value="7" />
<c:set var="num2" value="9" />
<%--multiple이라는 변수를 선언, 값을 num1이랑 num2를 곱한 수 --%>
<c:set var="multiple" value="${num1 * num2}"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>변수를 선언하는 방법 :: c:set</title>
</head>
<body>
<b>${num1} * ${num2} 의 곱은 ${multiple}입니다.</b>
</body>
</html>