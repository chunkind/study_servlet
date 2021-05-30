<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>배열에 값을 바인딩 함.</h2>
<%
	String[ ] winner = new String[3];
	winner[0] = "김유정";
	winner[1] = "김연아";
	winner[2] = "율리아";
	request.setAttribute("winner", winner);
	
	ArrayList<String> items = new ArrayList<String>();
	items.add("딸기");
	items.add("참외");
	items.add("레몬");
	items.add("수박");
	request.setAttribute("items", items);
	
	HashMap<String, String> map = new HashMap<String, String>();
	map.put("Edgar", "Boston");
	map.put("James", "Texas");
	map.put("Gosling", "India");
	map.put("Peter", "L.A");
	session.setAttribute("map", map);
		request.getRequestDispatcher("collectionEL3_view.jsp?name=Edgar").forward(request, response);
%>
</body>
</html>