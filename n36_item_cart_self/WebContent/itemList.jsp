<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	table{
		margin: 0 auto;
	}
</style>
</head>
<body>
	<h1 align="center">Fruit Total List 2</h1><p>
	<table>
		<tr>
			<c:forEach var="item" items="${ requestScope.rList }" varStatus="limit">
				<td>
					<a href="itemView.do?itemId=${ item.itemnumber }"><img border="1" src="${ item.url }" width=150, height=150></a><br>
					<font size="4">상품명 : ${ item.name }</font><br>
					상품가격 : ${ item.price }원
				</td>
				<c:if test="${ (limit.count % 5) == 0 }">
					</tr>
					<tr>
				</c:if>
			</c:forEach>
		</tr>
	</table>
</body>
</html>
