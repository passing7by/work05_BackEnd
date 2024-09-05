<%@page import="servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
 Member vo = (Member)session.getAttribute("vo");
 String product = (String)session.getAttribute("pname");
%>


<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%
	if(vo==null){ //로그인 한 상태가 아니라면
	%>

	<h3>로그인이 필요합니다</h3>
	<a href="login.html">로그인 하러 가기</a>

	<%
	 }else{ //로그인 한 상태가 아니라면
	%>

	<h2>result page</h2>
	id <%= vo.getId() %><br><br>
	name <%= vo.getPassword() %><br><br>
	address <%= vo.getAddress() %><br><br>
	product <%= product %>

	<%
	 }
	%>
</body>
</html>