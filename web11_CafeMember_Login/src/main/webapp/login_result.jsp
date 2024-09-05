<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Member vo = (Member)session.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<%
	if(vo==null){
	%>
	<h4>로그인부터 해주세요</h4>
	<a href="index.html">home</a>
	<%
	}else{
	%>
	
	<h2>login information</h2>
	id <%=vo.getId() %><br>
	name <%=vo.getName() %><br>
	address <%=vo.getAddress() %><br>
	<hr><br>
	<a href="logout.jsp">log out</a><br>
	<!-- 
	logout.jsp 는 세션을 죽이는 로직 하나만 필요 - session.invalidate()
	
	if(vo!=null){
	session.invalidate();
	}
	
	즉, 로그인 되어있다면 로그아웃 시킴
	-->
	
	<a href="index.html">home</a>
	<%
	}
	%>
</body>
</html>