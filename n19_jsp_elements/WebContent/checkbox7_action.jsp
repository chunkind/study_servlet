<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String[] angels = request.getParameterValues("angel");
	for(int i =0; i<angels.length; i++) {
		if(angels[i].equals("김유정")){
%>
	<img src="./img/love.jpg" width="20%" heigth ="20%">			
<% }else if(angels[i].equals("김연아")) { %>
	<img src="./img/kim.jpg" width="20%" heigth ="20%">			
<% }else if(angels[i].equals("아사다마오")) { %>
	<img src="./img/asada.jpg" width="20%" heigth ="20%">			
<% }else { %>
	<img src="./img/star.jpg" width="20%" heigth ="20%">			
<% } 
} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>