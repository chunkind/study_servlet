<%@page import="java.util.GregorianCalendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	GregorianCalendar now = new GregorianCalendar();    
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3><b><%= String.format("%TY년 %Tm월 %Td일", now,now,now) %></b></h3>
</body>
</html>