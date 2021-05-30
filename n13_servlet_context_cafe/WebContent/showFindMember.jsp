<%@page import="context.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    MemberDTO rdto = (MemberDTO)request.getAttribute("rdto");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">ID에 해당하는 회원의 정보입니다.</h2><p>
	당신의 이름은 :<%= rdto.getName() %><br>
	당신의 사는 곳은 : <%= rdto.getAddress() %><br>
<hr>
<a href="index.html"><b>다시 홈으로</b></a>
</body>
</html>