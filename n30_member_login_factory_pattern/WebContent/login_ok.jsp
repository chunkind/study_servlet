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
	<c:if test="${ sessionScope.rdto != null }">
		${ sessionScope.rdto.name } has signed in.<br>
		<a href="cafe.jsp">Enter cafe</a>
	</c:if>
</body>
</html>
