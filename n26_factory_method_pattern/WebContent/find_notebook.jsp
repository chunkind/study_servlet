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
<h2 align="center"><b>Find NoteBook</b></h2><p>
<form action="DispatcherServlet">
NoteBook Model :: <input type = "text" name = "model"><p>
<input type = "hidden" name = "command" value = "findNotebookModel">
<input type = "submit" value = "Search Model">
</form>
</body>
</html>
