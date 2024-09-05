<%@page import="web.servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
	
	</script>
</head>

<body>
	<c:choose>
		<c:when test="${user!=null}">
			<h2>${user.name} 님이 로그인 되었습니다!!!</h2>
			<p></p>
			<a href="./book/Book.html">도서 등록</a>
			<br>
			<a href="front.do?command=logout">로그아웃</a><br>
			<a href="front.do?command=bookList">도서목록</a>
		</c:when>
		<c:otherwise>
			<h4>로그인부터 해주세요</h4>
			<a href="login.html">home</a>
		</c:otherwise>
	</c:choose>
</body>
</html>