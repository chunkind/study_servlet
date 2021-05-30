<%@page import="model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
<h3 align="center"><font color='red'>
	전체 회원의 수는 ${fn:length(list)} 명 입니다.
</font></h3><p>
<table border="2" width="350" bgcolor='yellow' align='center'>
	<c:forEach var="list" items="${requestScope.list}" varStatus="vList">
		<tr>
			<td>${vList.count}</td>
			<td>${list.id}</td>
			<td>${list.name}</td>
			<td>${list.address}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>