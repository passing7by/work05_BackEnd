<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<b>1. jsp 기본 element로 받아오기</b><br>
	<%= request.getAttribute("RESULT1") %><br>
	<%= session.getAttribute("RESULT2") %><br>
	<hr>
	
	<b>2. jsp el로 받아오기</b><br>
	${RESULT1}<br>
	${RESULT2}<br>
	${RESULT1+50}<br>
</body>
</html>