<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>
		<c:out value="<forEach> 태그의 사용법" />
	</h2>
	<p>
	<h4>1. 1~100까지의 홀수의 합 :: set, forEach 태그를 사용</h4>
	<p>
		<c:forEach begin="1" end="100" step="2">
			<c:set var="sum" value="${sum+num}" />
		</c:forEach>
		<b>결과 :: ${sum} </b>
	<p>
	<hr>

	<h4>2. 구구단 중에서 7단 출력하기 :: forEach 사용</h4>
	<p>
		<%-- <c:forEach var="i" begin="1" end="9">
			7 * ${i} = ${7 * i}
	</c:forEach> --%>
		<c:forEach var="i" begin="7" end="7">
			<c:forEach var="j" begin="1" end="9">
		${i} *${j} = ${i*j }<br>
			</c:forEach>
		</c:forEach>
	<hr>

	<h4>3. 배열의 값 출력 :: int 타입의 배열 arr을 변수로 선언/ 1,2,3,4,5 값을 가진 배열 생성</h4><p>
		<c:set var="arr" value="1,2,3,4,5" />
		<c:forEach var="i" items="${arr}">
		${i}<br>
		</c:forEach>
	<hr>

	<h4>3. 배열의 값 출력2 :: int 타입의 배열 arr을 변수로 선언/ 1,2,3,4,5 값을 가진 배열 생성</h4><p>
		<c:set var="arr" value="<%=new int[] { 1, 2, 3, 4, 5 }%>" />
		<c:forEach var="i" begin="0" end="2">
		${arr[i]}
		</c:forEach>
	<hr>
	
	<h4>4. Map에 있는 데이타 출력하기(key=value 형식이 되도록)</h4>	<p>
	<%
		HashMap<String, String> mapData = new HashMap<String, String>();
		mapData.put("name","홍길동");
		mapData.put("age","19");
	%>
	<%-- set, forEach를 이용해서 age == 19 
							 name == 홍길동		--%>
		<c:set var="map" value="<%= mapData %>" />
		<c:forEach var="i" items="${map}" >
		${i.key} == ${i.value} <br>
		</c:forEach>
</body>
</html>