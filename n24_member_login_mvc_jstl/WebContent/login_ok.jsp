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
<body>
<c:choose>
	<c:when test="${sessionScope.rdto != null }">
		<b>${rdto.name}</b>님 로그인 성공!!
		<a href="cafe.jsp">성인 까페 입장하러 갑니다...ㅋㅋㅋ</a>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("로그인 부터 다시 시작하세여...");
			location.href="index.jsp";
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>