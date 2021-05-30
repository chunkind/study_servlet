<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="jstl2_choose.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- <%
	request.getRequestDispatcher("jstl2_choose.jsp").forward(request, response);
	request.getRequestDispatcher("jstl2_choose.jsp").include(request, response);
%>	 --%>
<%-- <jsp:include page="jstl2_choose.jsp" /> --%><!-- 뷰에서 뷰로 태그를 사용해서 이동할 때 사용. -->

<jsp:include page="jstl2_choose.jsp" />

<!-- 위의 지시어 include와 밑의 태그 include는 서로가 다르다.
	 지시어 안에는 Container에게 알려주는 정보가 들어간다. 이것은 컴파일 시점에서 끌어당겨진다. 
	 jsp가 만들어지면, WAS는 이것을 인식하기 위해서 자바로 변환하고 컴파일 한다 -> 서버로 만든다.
	 즉, 서블릿으로 만들기 전에 한번 더 과정이 생기는 이 컴파일 시점에 바로 include를 하는 것이 저 위의 지시어를 
	 이용한 방법이다.
	 지시어에 동적인문서(jsp)를 넣게 되면, 아무것도 나오지 않는다. 클라이언트가 요청하면 돌아가는 문서이기 때문이다.
	 그래서 반드시. img나html과 같이 컨테이너와 상관없는, 미리 데몬에서 응답할 수 있는 파일이 들어가야 한다.
	 그러므로 동적인 문서의 경우는 반드시 태그를 사용한 include를 하도록 한다. c:인 jstl을 통한 방법도 마찬가지로 가능하다.
	 -->

</body>
</html>