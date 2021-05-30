<%@page import="context.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	MemberDTO rdto = (MemberDTO)session.getAttribute("rdto");
	if(rdto != null){
		session.invalidate();
	}else{
%>
	<b>
	<a href="login_form.html">다시 로그인 부터</a>
	</b>

<%
	}
%>	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body onload="return logoutpop()">
	<b>로그 아웃 되셨습니다..</b><p>
	<a href="login_form.html">Go Home</a>
</body>
</html>