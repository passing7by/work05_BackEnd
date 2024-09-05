<%@page import="web.servlet.model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h2>login information</h2>
	id ${vo.id}<br>
	name ${vo.name}<br>
	address ${vo.address}<br>
	<hr><br>
	<a href="front,do?command=logout">log out</a><br>
	<!-- 
	logout.jsp 는 세션을 죽이는 로직 하나만 필요 - session.invalidate()
	
	if(vo!=null){
	session.invalidate();
	}
	
	즉, 로그인 되어있다면 로그아웃 시킴
	-->
	
	<a href="index.jsp">home</a>

</body>
</html>