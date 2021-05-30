<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>c:set을 이용해서 변수로 addr, name을 다시 선언해보자.</title>
</head>
<body>
<%
	MemberVO vo = new MemberVO("jstl","1234","JamesGosling","NY");
	request.setAttribute("vo", vo);
%>

1. EL TEST....<br>
<ul>
	<li>NAME :: ${vo.name}</li>
	<li>ADDR :: ${vo.address}</li>
</ul><p><hr>

2. JSTL TEST.... choose, when, otherwise<br>
<%--
	c:set이라는 변수선언하는 태그를 사용하자.
	requestScope.vo.address, requestScope.vo.name 이라는 부분을
	addr, name이라는 짧은 변수로 다시 선언해서 코드를 적용해보자.
	-- 세련된 방법의 c:set 사용법
	
 --%>
	<c:set var="addr" value="${requestScope.vo.address}"/>
	<c:set var="name" value="${requestScope.vo.name}"/>
	<c:choose>
	<c:when test="${addr=='NY'}">
		<b>${name}</b> 님은 뉴욕에 거주하고 계십니다.<br>
	</c:when>
	
	<c:when test="${addr=='판교'}">
		<b>${name}</b> 님은 판교에 거주하고 계십니다.<br>
	</c:when>
	
	<c:otherwise>
	<b>${name}</b> 님은 사이판에 휴장중이십니다.<br>
	</c:otherwise>
	
	</c:choose>
</body>
</html>



