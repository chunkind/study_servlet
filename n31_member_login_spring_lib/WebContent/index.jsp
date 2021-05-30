<%@page import="model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  
로그인 하지 않은 사용자는 단순회원 검색 / 로그인 / 회원가입 기능만 사용할수 있도록
로그인 한 사용자는 단순회원 검색 / 회원정보 수정 / 전체회원 보기 / 주소별회원검색 / 
                  로그아웃 기능을 사용할수 있도록 로직을 작성한다...이것이 포인트!!
-->
</head>
<body>
<h1><b>Login Member MVC  ::  회원관리 프로그램</b></h1><p>
<ul>
	<li><a href="find.jsp">회원 검색 하기</a></li>
</ul>

<c:choose>
	<c:when test="${sessionScope.rdto != null}">
	<ul>
		<li><a href="front.do">전체 회원 명단 보기</a></li>
		<li><a href="update.jsp">회원 정보 수정 하기</a></li>
		<li><a href="selectAddress.jsp">주소별 회원 검색 하기</a></li>
		<li><a href="LogoutServlet">로그 아웃 하기</a></li>
	</ul>
	</c:when>
	<c:otherwise>
	<ul>
		<li> <a href="login.jsp">로그인 하기</a></li>
		<li> <a href="register.jsp">회원 가입 하기</a></li>
	</ul>
	</c:otherwise>
</c:choose>
</body>
</html>