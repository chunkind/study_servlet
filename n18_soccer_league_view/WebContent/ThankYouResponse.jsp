<%@page import="sl314.domain.Player"%>
<%@page import="sl314.domain.League"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<TABLE BORDER='0' WIDTH='600'>
<TR>
<TD COLSPAN='2' BGCOLOR='#CCCCFF' ALIGN='center'>
<H3>Registration: Thank You</H3>
</TD></TR></TABLE><BR>

Thank you, ${player.name}, for registering!
in the <B>${league.title}</B> league . <br>
</body>
</html>