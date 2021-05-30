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
<%
	MemberDTO rdto = (MemberDTO)session.getAttribute("rdto");
	if(rdto != null){
%>
<%= rdto.getName()%>님 로그인 성공!!<br>
<a href="cafe.jsp">성인 카페 입장하러 갑니다.ㅋㅋ</a>
<% } %>		
</body>
</html>