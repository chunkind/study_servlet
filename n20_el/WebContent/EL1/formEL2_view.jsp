<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   <%
   request.setCharacterEncoding("utf-8");
   response.setContentType("text/html;charset=utf-8");
   %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>html 폼에 입력된 값을 넘겨받습니다.</h2><p>
<b>1. 기존의 JSP Element(Scriptlet, Expression Element)를 사용해서 값 출력</b>
<%
   String id = request.getParameter("id");
   String[] pets = request.getParameterValues("pet");
   for(String p : pets){
      out.println(p+"<br>");
   }
%>
아이디 : <%= id %> <br>
<hr>
<b> 2. EL 식을 이용해서 출력하기. </b><p>
아이디 : ${param.id}<br>
선택한 애완동물 : 
${paramValues.pet[0]}<br>
${paramValues.pet[1]}<br>
${paramValues.pet[2]}<br>
${paramValues.pet[3]}<br>
${paramValues.pet[4]}<br>
</body>
</html>
<!-- 
request.getParameter("id") : param.id
request.getParameterValues("pet") : ${paramValues.pet[0]}
pageScope
requestScope
sessionScope
applicaionScope
 -->