<%@page import="java.util.ArrayList"%>
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
	<%
		String[] jangs = { "을지문덕", "이순신", "최영", "온달" };
		request.setAttribute("jangs", jangs);
	%>
	
1.	배열에 들어있는 장군들을 Scriptlet, Expression Element을 이용해서 출력<br>
	이때 순번 찍어서...	<p>
	<%
		for (int i = 0; i < jangs.length; i++) {
	%>
	<%=i + 1%>.	<%=jangs[i]%><br>
	<%
		}
	%>
<p><hr>
	
2. 배열안에 있는 장군들을 JSTL을 이용해서 EL로 출력하기.(순번 찍히도록..) <br>
	<c:forEach var ="js" items="${jangs}" varStatus="vjs">
	${vjs.count}.${js}<br>
	</c:forEach>
<hr>

<%
	ArrayList list = new ArrayList();
	list.add("최민재");
	list.add("박정기");
	list.add("박종완");
	list.add("김유정");
	list.add("아이유");
	list.add("솔비");
	request.setAttribute("list", list);
%>

3. ArrayList안에 들어있는 데이타 들을 JSTL을 이용해서 출력하기. (0 ~ n)<p>
	<c:forEach var = "list" items="${list}" varStatus="vList">
	${vList.count-1}.${list}<br>
	</c:forEach>

4. ArrayList안에 들어있는 데이타 들중 1~3위 까지의 사람만 출력..(1위. 최민재 6위. 솔비)<p>
	<c:forEach var = "list" items="${list}" varStatus="vList" begin="0" end="2">
	${vList.count}위.${list}<br>
	
	</c:forEach> 

</body>
</html>