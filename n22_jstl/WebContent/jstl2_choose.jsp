<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>choose, when, otherwise</title>
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
	주소가 NY(뉴욕)이라면 ~~님은 뉴욕에 거주하고 계십니다..를 웹으로 출력
	주소가 판교라면 ~~님은 판교에 거주하고 계십니다..를 웹으로 출력
	위의 주소가 둘다 아니라면 ~~님은 사이판에 휴양중이십니다.를 웹으로 출력
 --%>
	<c:choose>
	
	<c:when test="${requestScope.vo.address=='NY'}">
		<b>${requestScope.vo.name}</b> 님은 뉴욕에 거주하고 계십니다.<br>
	</c:when>
	
	<c:when test="${requestScope.vo.address=='판교'}">
		<b>${requestScope.vo.name}</b> 님은 판교에 거주하고 계십니다.<br>
	</c:when>
	
	<c:otherwise>
	<b>${requestScope.vo.name}</b> 님은 사이판에 휴장중이십니다.<br>
	</c:otherwise>
	
	</c:choose>
	<hr>
</body>
</html>



