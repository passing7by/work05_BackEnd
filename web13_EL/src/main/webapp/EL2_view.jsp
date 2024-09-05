<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<b>1. jsp 기본 element 사용하기</b>
	<%=request.getParameter("myId") %><br>
	
	<b>2. jsp el 사용하기</b>
	${param.myId}<br>
	<hr>
	
	<b>3. jsp menu에 해당하는 값 element로 받아오기</b>
	<%
	String[] menus = request.getParameterValues("menu");
	for(String menu : menus){
	%>
	<b><%=menu %></b>
	<%
	}
	%><br>
	
	<b>4. jsp menu에 해당하는 값 el로 받아오기</b><br>
	선택한 메뉴 ::
	${paramValues.menu[0]}
	${paramValues.menu[1]}
	${paramValues.menu[2]}
	${paramValues.menu[3]}
	
	</body>
</html>