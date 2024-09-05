<%@page import="web.servlet.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h2>결과 페이지</h2>
	<p>${book.title} ${msg}</p>
	<a href="./book/Book.html">추가 등록</a>
	<a href="front.do?command=bookList">도서 목록</a>
</body>
</html>