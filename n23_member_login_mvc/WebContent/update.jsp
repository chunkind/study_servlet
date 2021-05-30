<%@page import="javax.swing.Action"%>
<%@page import="model.MemberDTO"%>
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
<h2 align="center"><b>회원정보 수정 하기</b></h2><p>
<!-- 회원정보를 수정하기 위해서는 반드시 로그인 한 상태에서 해야 한다..
	 즉 세션에 수정하고자 하는 DTO가 바인딩 되어져 있어야 한다.
 -->
<% MemberDTO rdto = (MemberDTO)session.getAttribute("rdto");%>
<%
if(rdto != null){
%>
	<form action="UpdateServlet" method = "post" name = "updateForm" onsubmit = "return updateData()">
	아이디 : <input type = "text" name = "id" value = "<%= rdto.getId() %>" readonly="readonly"><p>
	패스워드 : <input type = "text" name = "password" value = "<%= rdto.getName() %>" readonly="readonly"><p>
	이 름 : <input type = "text" name = "name" value = "<%= rdto.getPassword() %>" required="required"><p>
	주 소 : <input type = "text" name = "address" value = "<%= rdto.getAddress() %>" required="required"><p>
	
	<input type = "submit" value = "register">
	<input type = "reset" value = " clear">
<%
}else{
%>
	<script type = "text/javascript">
		alert("수정하려면 로그인 부터 진행하세요!");
		location.href="login.jsp";
		/* alert("회원에 대한 정보가 없어서 수정할 수 없습니다.");
		location.href="lndex.jsp"; */
	</script>
<% } %>
<%-- <form action = "UpdateServlet" method = "post">
	아이디 :	<input type = "text" name = "id" readonly="readonly" value ="<%= rdto.getId()%>"><p>
	패스워드 : <input type = "password" name = "password" required="required"><p>
	이 름 :	<input type = "text" name = "name" required="required"><p>
	주 소 :	<input type = "text" name = address" required="required"><p>
<input type = "submit" value = "register">
<input type = "reset" value = " clear"> --%>
</form>
</body>
</html>