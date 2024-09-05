<%@page import="web.servlet.vo.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% Product product = (Product)request.getAttribute("product");%>
<!-- 바인딩 한 값 가져오기 -->

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<h2>상품이 저장되었습니다.</h2>
	<b>상품번호   </b><%=product.getpNo() %><br>
	<b>상품명   </b><%=product.getpName() %><br>
	<b>상품가격   </b><%=product.getpPrice() %><br>
	<b>상품설명   </b><%=product.getpDesc() %><br><br>
	<hr>
	<a href="List">상품 목록</a>
	<!-- 서블릿으로 다시 이동 (비지니스 로직 호출 위해), 메소드 방식 지정할 수 없음(form 아니기때문) => List서블릿은 get으로 -->
</body>
</html>