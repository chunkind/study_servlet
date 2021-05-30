<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- forEach  -->
<h1 align = "center"> Fruit Total List2.</h1><p>
<table align = "center">
	<tr>
		<c:forEach var = "item" items = "${requestScope.list}" varStatus="limit">
			
			<td><a href = "itemView.do?itemnumber= ${item.itemnumber}">
			<img alt = "" src = "${item.url}" width = "150" height = "150" border = "2"></a>
			<br>
			<b>상품명 : ${item.name}</b><br>
			<b>가 격 : ${item.price}원</b>
			</td>
			<c:if test ="${(limit.count % 5)==0}">
			</tr>
			<tr>
			</c:if>
		</c:forEach>
	</tr>
</table>
</body>
</html>