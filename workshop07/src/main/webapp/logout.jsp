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
	function logout() {
		alert("로그아웃 완료")
	}
	</script>
</head>

<body onload="return logout()">

	<c:choose>
		<c:when test="${user!=null}">
			<b>로그아웃 되셨습니다.</b><br>
			<a href="login.html">home</a>
		</c:when>
		<c:otherwise>
			<b>로그인부터 해주세요.</b><br>
			<h3><a href="login.html">로그인 하러 가기</a></h3>
		</c:otherwise>
	</c:choose>
</body>
</html>