<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h2>회원가입을 위해 정보를 입력해 주세요.</h2>
	<form action="front.do" method="post">
		<input type="hidden" name="command" value="register">
		<!-- 히든 태그 추가 -->
		id <input type="text" name="id" required="required"><br>
		password <input type="text" name="password" required="required"><br>
		name <input type="text" name="name"><br>
		address <input type="text" name="address"><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>