<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- jsp 기술은 코드를 지양하는 방식으로 발전해 왔다.
   	 jsp 태그중에서(basic element) 코드가 들어가는 엘러먼트는 <%		%>
   	 scriptlet element이다
   	 결론적으로 jsp 기술은 scriptlet element를 줄이는데 목적을 둔다고 해도 
   	 과언이 아니다.
   	 그것을 해결하기 위한 방안으로 EL(Expression Language)가 나왔다.
   	 ::
   	 EL이 어떤 방식으로 돌아가길래...JSP에서 코드가 줄어들수 밖에 없는지를 정리.
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	int sum =0;
	for(int cnt=0; cnt<=100; cnt++){
		sum += cnt;
	}
	
	request.setAttribute("RESULT", new Integer(sum));
	session.setAttribute("RESULT", "세션");
	//response.sendRedirect("el1_view.jsp");
	request.getRequestDispatcher("el1_view.jsp").forward(request, response);
%>
</body>
</html>