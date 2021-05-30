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
<c:import url="header.jsp"></c:import>
<h2 align = "center">전체 게시물 보기</h2> <br>
<table cellpadding = "5" align = "center">
<tr>
	<td valign="center">
		<table width = "600" border = "1">
		<tr>
			<th>번호</th>
			<th width = "250">제목 </th>
			<th>작성자</th>
			<th>작성일</th>
			<th>조회수</th>
		</tr>
		<c:forEach var = "rlist" items ="${rlist}">
			<tr>
				<td>${rlist.no}</td>
				<td><a href ="DispatcherServlet?command=showContent&&no=${rlist.no}">${rlist.title}</a></td>
				<td>${rlist.writer}</td>
				<td>${rlist.timePosted}</td>
				<td>${rlist.hits}</td>
			</tr>
		</c:forEach>
		</table>
	<a href="write.jsp">
      <img src="img/write_btn.jpg" alt="글쓰기">
   	 </td>  
   	 </table>
  	</form>
	</body>
</html>