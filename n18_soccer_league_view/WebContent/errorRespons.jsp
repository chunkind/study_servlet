<%@page import="java.util.Iterator"%>
<%@page import="sl314.util.Status"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
Status status = (Status) request.getAttribute("status");


// Generate the HTML response
out.println("<HTML>");
out.println("<HEAD>");
out.println("<TITLE>Registration: Form Errors</TITLE>");
out.println("</HEAD>");
out.println("<BODY BGCOLOR='white'>");
out.println("<TABLE BORDER='0' WIDTH='600'>");
out.println("<TR>");
out.println("  <TD COLSPAN='2' BGCOLOR='#CCCCFF' ALIGN='center'>");
out.println("    <H3>Registration: Form Errors</H3>");
out.println("  </TD>");
out.println("</TR>");
out.println("</TABLE>");
out.println();
out.println("<BR>");
out.println("There were problems processing your request:");
out.println("<FONT COLOR='red'>");
out.println("<UL>");
Iterator errors = status.getExceptions();
while ( errors.hasNext() ) {
  Exception ex = (Exception) errors.next();
  out.println("  <LI> " + ex.getMessage());
}
out.println("</UL>");
out.println("</FONT>");
out.println("Please, back up and try again.");
out.println("</BODY>");
out.println("</HTML>");
%>
</body>
</html>