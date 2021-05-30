<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	
</style>
</head>
<body>
	<h1 align="center">${item.name }의 정보</h1>
	<table align="center" width="600">
		<tr bgcolor="orange">
			<td align="right">
				조회수 : ${rItem.count } &nbsp;&nbsp;&nbsp;&nbsp; 
				<a href="itemCartAdd.do?itemnumber=${ rItem.itemnumber }">장바구니 담기</a>
			</td>
		</tr>
	</table>
	<table align="center" width=600>
		<tr>
			<td rowspan="3"><img src="${rItem.url }">	</td>
			<td>종 류 :  ${rItem.name }</td>
			
		</tr>
		<tr>
			<td>가 격 : ${rItem.price }</td>
		</tr>
		<tr>
			<td>설 명 : ${rItem.description }</td>
		</tr>
		<tr>
			<td align="center"><a href="itemList.do">상품 목록 보기</a></td>
		</tr>
	</table>
</body>
</html>
