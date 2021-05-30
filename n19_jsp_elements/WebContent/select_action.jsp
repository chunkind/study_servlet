<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  
폼값을 넘긴걸 여기서 받는다.
1~5호선 일때 서울 지하철을 선택하셨습니다..를 웹으로 출력.(body)
6~9호선 일때는 국철을 선택하셨습니다..를 웹으로 출력.(body)
-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	String subLine= request.getParameter("line");
	int line = Integer.parseInt(subLine);
	if(line<=5){
	
	%>
</head>
<body>
	단신은 서울 지하철 <b><%= line %> 호선 </b>을 선택하셧습니다..<br>
<% }else{ %>
	단신은 국철 <b><%= line %> 호선 </b>을 선택하셧습니다..<br>
	<% } %>
</body>
</html>
