
<!-- 
jsp에서 에러를 핸들링하는 방법
::
1.	response.sendRedirect("error.jsp");
2.	지시어 ( Directive Element)를 이용하는 방법
	이때 errorPage/isErrorPage 두개의 속성이 쓰인다.
 -->


<%@ page 
		language="java" 
		contentType="text/html; charset=UTF-8"
    	pageEncoding="UTF-8" 
    	
    	import="java.util.Date"
    	import="java.util.HashMap, java.sql.Connection"
    	isErrorPage="true"
    	%>  
    	
<!DOCTYPE html>
<%	Date d = new Date(); 
	Connection conn = null;
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Error Page.</h2><p>
<h3>
<b> 해당 페이지에서 이유를 알수 없는 에러가 발생했습니다.<br>
	신속히 에러를 해결하겠습니다..<br>
	불편을 끼쳐드려 대단히 죄송합니다.. ^^;;
</b>
	<img alt="" src="./img/star.jpg">
</h3>
<b>
	<table>
		<tr>
			<td></td>
		</tr>
	</table>
</b>
Error Message :: <b><%= exception.getMessage() %></b>
</body>
</html>