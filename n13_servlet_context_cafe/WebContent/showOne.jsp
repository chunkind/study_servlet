<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getParameter("name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2><b><%= name %> 님, </b> Cafe Register Success!! </h2><p>
<a href="ShowAllMemberServlet">전체 명단 보러가기</a> &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; 
<a href="index.html">홈으로..</a>
</body>
</html>