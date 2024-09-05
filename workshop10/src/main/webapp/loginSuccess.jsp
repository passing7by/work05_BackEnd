<%@page import="web.servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


	

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<style type="text/css">
	#flex{
		text-align: center;
	}
	h1{
		color: crimson;
	}
</style>
</head>

<body>
<c:if test="${!empty user }">
<div id="flex">
  <h1>${user.name}님이 로그인 되었습니다!!</h1>
  <br><br>
  <a href="./book/Book.html">도서 등록</a><br><br>
  <a href="showAll.do">도서 목록</a><br><br>
  <a href="logout.do">로그아웃</a><br>
 </div>
 </c:if>
</body>

</html>
