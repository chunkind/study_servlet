<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Main page</title>
<!-- 로그인하지 않는 사용자는 단순 회원 검색 / 로그인 / 회원가입 기능 -->
<!-- 로그인한 사용자는 단순 회원 검색 / 회원정보 수정 / 전체 회원 보기 / 주소별 회원 검색 / 로그아웃 -->
</head>
<body>
	<h1 align="center"><font color="RED">Login Page</font></h1><p>
	<form name="action">
		<ul>
			<li><a href="find.jsp">회원 검색하기</a>
		</ul>
		<c:choose>
			<c:when test="${ sessionScope.rdto != null }">
				<ul>
					<li><a href="DispatcherServlet?command=showAllMember">전체 회원 명단보기</a>
					<li><a href="update.jsp">회원 정보 수정하기</a>
					<li><a href="selectAddress.jsp">주소별 회원 검색하기</a>
					<li><a href="DispatcherServlet?command=logout">로그아웃 하기</a>
				</ul>
			</c:when>
			<c:otherwise>
				<ul>
					<li><a href="login.jsp">로그인 하기</a>
					<li><a href="register.jsp">회원가입 하기</a>
				</ul>
			</c:otherwise>
		</c:choose>
	</form>
</body>
</html>
