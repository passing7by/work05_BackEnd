<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h2>회원 검색 (단순 검색)</h2>
	<form action="Find" method="post">
		조회id <input type="text" name="id" required="required">
		<input type="submit" value="회원 검색">
	</form>
</body>
</html>