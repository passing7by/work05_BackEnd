<%@page import="web.servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% User user = (User)session.getAttribute("user"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
	
	</script>
</head>

<body>
	<%
	if(user==null){
	%>
	<h4>로그인부터 해주세요</h4>
	<a href="login.html">home</a>
	<%
	}else{
	%>
	
	<h2><%= user.getName() %> 님이 로그인 되었습니다!!!</h2>
	<p></p>
	<a href="./book/Book.html">도서 등록</a>
	<br>
	<a href="logout.jsp">로그아웃</a>
	<%
	}
	%>
</body>
</html>