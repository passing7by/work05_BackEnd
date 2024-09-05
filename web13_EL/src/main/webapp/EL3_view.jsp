<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>
	<b>el로 바인딩된 vo 데이터 출력</b><br>
	<%-- id : ${vo.getId()}<br>
	name : ${vo.getName()}<br>
	address : ${vo.getAddress()} --%>
	id : ${vo.id}<br>
	name : ${vo.name}<br>
	address : ${vo.address}
	<!-- 모든 것은 getter를 줄인 것임.... -->
</body>
</html>