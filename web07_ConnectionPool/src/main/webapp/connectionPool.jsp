<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="java.net.ConnectException"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%//임포트 주의 %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h2>ConnectionPool Test...using jndi service</h2>
	
	<%
	Context ic=new InitialContext();
	DataSource ds=(DataSource)ic.lookup("java:comp/env/jdbc/mysql");
	
	out.println("<b>1. datasource lookup...</b>");
	
	Connection conn = ds.getConnection();
    out.println("<br><b>2. Connection Rent Success~~!! </b>");
	%>
</body>
</html>