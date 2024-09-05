<%@page import="web.servlet.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% Book book = (Book)request.getAttribute("book"); %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h2>결과 페이지</h2>
	<p><%=book.getTitle() %> 정상적으로 저장되었습니다.</p>
	<a href="./book/Book.html">추가 등록</a>
	<a href="#">도서 목록</a>
</body>
</html>