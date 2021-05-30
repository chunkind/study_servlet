
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Error Handling</h2><p>
<h3>direct2.jsp에서 예기치 못한 에러 발생 </h3><p>
<% 
	int i=10/0;
	out.println(i);
%>
</body>
</html>
