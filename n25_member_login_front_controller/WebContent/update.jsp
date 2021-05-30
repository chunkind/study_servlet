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
<h2>회원 정보 수정 하기</h2><p>
<!-- 회원정보를 수정하기 위해서는 반드시 로그인 한 상태에서 해야 한다...
	 즉 세션에 수정하고자 하는 DTO가 바인딩 되어져 있어야 한다.
 -->
<c:choose>
	<c:when test="${sessionScope.rdto != null }">
	<form action="front.do" method="post" name="updateForm">
	<input type="hidden" name="command" value="update">
		아이디 :<input type="text" name="id" value="${rdto.id}" readonly="readonly"><p>
		패스워드 :<input type="password" name="password" value="${rdto.password}" readonly="readonly"><p>
		이  름 :<input type="text" name="name" value="${rdto.name}" required="required"><p>
		주  소 :<input type="text" name="address" value="${rdto.address}" required="required"><p>
		<input type="submit" value="수정하기">
	</form>
	</c:when>
	<c:otherwise>
		<script type="text/javascript">
			alert("수정하려면 로그인 부터 진행하세요!!");
			location.href="login.jsp"; 
		</script>
	</c:otherwise>
</c:choose>
</body>
</html>