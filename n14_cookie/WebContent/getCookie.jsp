<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Cookie[] cs = request.getCookies();
		for (Cookie c : cs) {
	%>
	<%= c.getName() %> :: <%= c.getValue() %><br>
	<%
		}
	%>
<a href='index.html'>Go Home..</a>
</body>
</html>