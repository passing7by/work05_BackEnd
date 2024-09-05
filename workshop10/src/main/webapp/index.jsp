<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	h1, h4{
		text-align: center;
	}
	a{ margin: 15px; }
</style>
</head>
<body>
	<H1>INDEX PAGE</H1>
	<p/>
	<h4>${msg }</h4>
	<c:if test="${empty user }">
		<%-- <jsp:include page="login.html"/> --%>
		<c:import url="login.html"></c:import>
		<h4><a href="register.do">회원 가입</a></h4>
		<h4><a href="showAll.do">도서 목록</a></h4>
	</c:if>
	<c:if test="${!empty user }">
		<h4><a href="./book/Book.html">도서 등록</a>
		<a href="showAll.do">도서 목록</a></h4>
	
	
	</c:if>
</body>
</html>