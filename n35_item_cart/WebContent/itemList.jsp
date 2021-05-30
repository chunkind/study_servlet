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
<h1 align="center"> Fruit Total List Using Cookie 4.</h1><p>
<table align="center">
	<tr>
		<c:forEach var="item" items="${requestScope.list}" varStatus="cnt">
		
			<td><a href="itemView.do?itemnumber=${item.itemnumber}">
			<img alt="" src="${item.url}" width="150" height="150" border="2"></a>
			<br>			
			<b> 상품명 : ${item.name}</b><br>
			<b> 가  격 : ${item.price}원</b>
			</td>
			
		<c:if test="${cnt.count %5 ==0 }">
			<tr></tr>
		</c:if>
		
		</c:forEach>
	</tr>
</table><br><br>
<hr>
<!-- 이 부분은 오늘 본 상품정보를 뿌려주는 테이블 영역이다.
	 쿠키에 저장된 이미지를 뿌려 준다.
 -->
 <h2 align = "center"><front color= "orange"> 오늘 본 상품들.</h2>
<table align = "center bgcolor = "lightgray">
	<tr>
		<c:forEach var = "image" items = "${requestScope.images}">
			<td><img src="${image}" width ="100" height ="100"></td>
		</c:forEach>
	</tr> 
</table>
</body>
</html>














