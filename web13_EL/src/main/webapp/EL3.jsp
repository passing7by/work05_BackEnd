<%@page import="vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	MemberVO vo = new MemberVO("11","111","1111","11111");
	request.setAttribute("vo", vo);
	request.getRequestDispatcher("EL3_view.jsp").forward(request, response);
%>
</body>
</html>