<%@page import="context.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- Scriptlet Element -->
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
<h2><b>당신의 정보를 출력합니다..</b></h2><p>
이 름 : <% out.println(rdto.getName()); %><br>
<!-- Expression Element :: ;를 넣으면 안된다. -->
아이디 : <%= rdto.getId() %><br>	<!-- out.println() -->
주 소 : <%= rdto.getAddress() %><br>
</body>
</html>