<%@page import="context.model.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true" %>
    <%
    MemberDTO rdto = (MemberDTO)session.getAttribute("rdto");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Login Information</h2><p>
Login ID :: <%= rdto.getId() %><br><br>
User Name :: <%= rdto.getName() %><br><br>
User Address :: <%= rdto.getAddress() %><br><br>
JSESSION ID value :: <%= session.getId() %><br><br>
<hr>
<a href="logout.jsp"><font color="red" size="15">Going Logout~</font></a>
<a href="login_form.html"><font color="blue" size="15">Going Login Page~~</font></a>
</body>
</html>