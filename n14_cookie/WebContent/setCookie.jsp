<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	Cookie cookie = new Cookie("name","habaree");
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
Cookie Setting 1 :: <br>
<%= cookie.getName() %>-------------------<%=cookie.getValue() %><br>
<hr>
Cookie Setting 2 :: <br>
<% out.println(cookie.getName()); %>--------------<% out.println(cookie.getValue()); %><br>

<hr>
<a href='getCookie.jsp'>쿠키에 저장된 값 받아오기.. 두번째 링크.</a>
</body>
</html>