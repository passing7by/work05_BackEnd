<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<h2>c:choose 문법 사용하기 :: 양자택일...또다른 조건을 부여할 때</h2>
	<c:choose>
		<c:when test="${param.NUM=='100'}">
			<b>자동차세 100만원이 입금되었습니다.</b>
		</c:when>
		
		<c:when test="${param.NUM=='200'}">
			<b>재산세 200만원이 입금되었습니다.</b>
		</c:when>
		
		<c:otherwise> <!-- if의 else, 혹은 swich의 default와 같음 -->
			<b>고객님, 입금액을 다시 한 번 확인해주세요.</b>
		</c:otherwise>
	</c:choose>
</body>
</html>