<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	if(age >=19){
%>
<b><%= name %>님, </b> 환영합니다. 입장하세요.
<% }else{ %>
<script type="text/javascript">
	alert("나이 더 먹고 오삼..");
	location.href="element5.html";
</script>
<% } %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>