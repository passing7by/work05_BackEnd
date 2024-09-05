<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>



<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>index</title>
	<style type="text/css">
		h1, h4{
			text-align: center;
		}
		a{
			margin: 15px;
		}
	</style>
</head>

<body>
	<h1>index page</h1>
	<p></p>
	
	<h4>${msg}</h4>
	
	<c:if test="${empty user}">
		<jsp:include page="login.html"></jsp:include>
		<h4>
			<a href="front.do?command=addMember">회원 가입</a>
			<a href="front.do?command=bookList">도서 목록 보기</a>
		</h4>
	</c:if>
	
	<c:if test="${not empty user}">
			<h4><a href="./book/Book.html">도서 등록</a></h4>
			<h4><a href="front.do?command=bookList">도서 목록</a></h4>
	</c:if>
</body>
</html>