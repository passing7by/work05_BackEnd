<%@page import="web.servlet.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
User user = (User)session.getAttribute("user");
%>


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
	<%
	if(user==null){ //로그인 안 된 상태라면 로그인 페이지로 연결
	%>
	<h3><a href="login.html">로그인 하러 가기</a></h3>
	
	<%	
	}else{ //로그인 된 상태라면...로그아웃 진행 (세션을 death 시킴){
		session.invalidate();
	%>
	<b>로그아웃 되셨습니다.</b><br>
	<a href="login.html">home</a>
	<%
	}
	%>
</body>
</html>