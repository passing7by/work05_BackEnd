<%@page import="workshop03.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% User user = (User)request.getAttribute("user"); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h2>로그인 실패!!!</h2>
	<p></p>
	<a href="#">로그인 다시 하기</a>
</body>
</html>