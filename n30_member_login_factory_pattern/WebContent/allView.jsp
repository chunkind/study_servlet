<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table tr:HOVER{
		background-color: pink;
	}
	#th{
		background-color: red;
	}
</style>
</head>
<body>
	<h1>Member List in this cafe</h1>
	<!-- 전체 회원은 총 ~명 입니다. -->
	<table align="center" border="1" width=40%>
		<tr id="th">
			<th>아이디</th>
			<th>이   름</th>
		</tr>
		<c:forEach var="member" items="${ requestScope.rList }">
			<tr>
				<td>${ member.id }</td>
				<td>${ member.name }</td>
			</tr>
		</c:forEach>
	</table>
	<h3>전체 회원은 총 ${ fn:length(rList) }명 입니다.</h3>
</body>
</html>
