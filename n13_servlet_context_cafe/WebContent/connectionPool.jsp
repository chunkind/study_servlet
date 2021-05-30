<%@page import="javax.naming.NamingException"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">Connection Pooling Test....</h2><p>
<%
	Connection conn = null;

	//1. Naming Service를 제공하는 객체를 먼저 생성
	//우리는 Context.xml에 이미 jdbc/oracleDB 라는 이름으로 factory를 등록해놨다
	//여기서 찾아오기만 하면 된다.
	try{
	Context ic   =  new InitialContext();
	
	DataSource ds=(DataSource)ic.lookup("java:comp/env/jdbc/oracleDB");
	out.println("DataSource Lookup.....Using Naming Service....");
	
	//2. ConnectionFactory(BasicDataSource)를 하나 찾아왔따..
	//그 공장안에 있는 Connection을 하나 리턴 받으면 된다.
	//이때 DriverManager 의 getConnection()을 사용했지만...
	//DataSource의 getConnection()을 사용하면 pool에 있는 Connection을 하나
	//리턴받아올수 있게 된다.
	
	conn=ds.getConnection();
		out.println("<h2><b>Pool에서 Connection을 Rent 해오는데 성공했습니다...</b></h2><p>");
	}catch(NamingException e){
		out.println("<h2><b>Pool에서 Connection을 Rent 해오는데 실패했습니다..</b></h2><p>");
	}
%>
</body>
</html>


















