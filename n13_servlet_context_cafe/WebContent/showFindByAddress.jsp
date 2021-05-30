<%@page import="context.model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	ArrayList<MemberDTO> returnList = (ArrayList<MemberDTO>)request.getAttribute("returnList");
    	System.out.println(returnList.get(0).getId());
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">동일한 주소에 거주하는 회원님들 입니다.</h2><p>
<%=request.getParameter("address") %> 에 사는 회원님들은 <%= returnList.size() %> 명입니다.<br><br>

<table border='1'>
	<% for(int i =0; i<returnList.size(); i++) {%>
	<tr>
		<td><%= i+1 %></td>
		<td><%= returnList.get(i).getName() %></td>
		<td><%= returnList.get(i).getAddress() %></td>
	</tr>
	<% } %>	
</table>
</body>
</html>