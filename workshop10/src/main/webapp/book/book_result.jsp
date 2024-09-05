<%@page import="web.servlet.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	*{
		text-align: center;
	}
</style>
</head>
<body>
<c:if test="${!empty user }">
	<h1>결과 페이지</h1><br><br>
${vo.title} ${msg}<br><br>
<a href="book/Book.html">추가 등록</a><br>
<a href="showAll.do">도서 목록</a>
</c:if>
</body>
</html>