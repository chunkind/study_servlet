<%@page import="context.model.MemberDTO"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	ArrayList<MemberDTO> returnList = (ArrayList<MemberDTO>)request.getAttribute("returnList");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- 
1. body의 자식태그인 table 태그를 선택자로 지정.. 중앙정렬
2. tr의 자식태그인 td의 내용을 가운데 정렬
3. th를 선택자로 지정하고 배경색을 red, 글자색은 white
4. 각각 테이블의 행(줄)을 선택하면 Hover효과 나도록.. 배경색은 pink
5. table의 border를 2실선.. 색깔 주고
 -->
 <style type="text/css">
 	body table{

 	/* 	margin 0px;
 		margin-left: auto;
 		margin-right: auto; */
 		
 		margin: 0 auto;
 		width : 50%;
 		border: 2px solid red;
 	}
 	tr td{
 		text-align: center;
		
 	}
 	table tr:HOVER {
	background-color: pink;
}
	th{
		background-color: red;
		color: white;
	}
 </style>
</head>
<body>
<h2 align="center">전체 회원 명단 리스트 보기</h2><p>

<!-- html 주석 입니다.. -->
<%-- jsp 주석 입니다..
<%
	out.print("<table border=2>");
	for(int i=0; i<returnList.size(); i++){
		out.print("<tr><td>"+(i+1)+"</td>");
		out.print("<td>"+returnList.get(i).getName()+"</td>");
		out.print("<td>"+returnList.get(i).getAddress()+"</td></tr>");
	}
	out.print("</table>");
%> --%>

<table border="2">
	<th>번 호</th><th>아이디</th><th>이 름</th><th>주 소</th>
	<% for(int i=0; i<returnList.size(); i++){%>
		<tr>
			<td><%= i+1 %> </td>
			<td><%= returnList.get(i).getId() %> </td>
			<td><%= returnList.get(i).getName() %> </td>
			<td><%= returnList.get(i).getAddress() %> </td>
		</tr>
	<% } %>
</table>
</body>
</html>