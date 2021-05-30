<%@page import="model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
ArrayList<MemberDTO> list = (ArrayList<MemberDTO>)request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	td{
	text-align: center;
	}
</style>
</head>
<body>
<h2 align="center"><b>전체 회원 명단 보기</b></h2><p>
<table border = "2" width = "350" bgcolor = "yellow" align = 'center'>
	<%
		for(int i=0; i<list.size(); i++){
	%>
			<tr>
				<td><%= list.get(i).getId() %></td>
				<td><%= list.get(i).getName() %></td>
				<td><%= list.get(i).getAddress() %></td>
			</tr>
		<%
		}
		%>	
</table>
</body>
</html>