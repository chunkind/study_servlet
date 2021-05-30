<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="red">
<c:choose>
	<c:when test="${sessionScope.rdto != null}">
		${rdto.address }에 사는 ${rdto.name}님 까페 입장 환영!!<p> 
		<a href="index.jsp">홈으로</a>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
		alert("당신!! 로그인부터 하고 들어와야쥐!!!");
		location.href="login.jsp";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>