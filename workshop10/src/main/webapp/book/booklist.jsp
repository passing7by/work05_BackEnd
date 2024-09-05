<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<title>Insert title here</title>
<style type="text/css">
	body{
		text-align: center;
	}
	#right{
		display: flex;
		justify-content: flex-end;
	}
	#table,#table *{
		border: 1px solid black;
		border-collapse: collapse; 
	}
	#table{
		width: 1000px;
	}
	#table th{
		background: gray;	
	}
	#tablediv{
		display: flex;
		justify-content: center;
	}
</style>
</head>
<body>
	
	<h1>도서 목록 화면</h1><br>
	<div id="right">
	<form action="showAll.do" id="frm" method="post">
	<input type="hidden" name="command" value="showAll">
	<c:if test="${!empty user}"> 
		<font color="blue">${user.name}님 로그인 되셨습니다. <a href="logout.do">로그아웃</a></font>
	</c:if>
	<select name="type">
		<option value="전체">전체
		<option value="도서명">도서명
		<option value="출판사">출판사
	</select>
	<input type="text" name="keyward" id="keyward">
	<button id="search">검색</button>
	</form>
	</div>
	<div id="tablediv">
	<table id="table">
		<tr>
			<th>도서번호</th>
			<th>도서명</th>
			<th>도서분류</th>
			<th>저자</th>
		</tr>
	<c:choose>
		<c:when test="${list.size()==0}">
			<tr>
				<td colspan="4" style="text-align: center;color: red;"> 등록된 책이 없습니다. 책을 등록해 주세요.</td>
			</tr>
		</c:when>
		<c:otherwise>
		<c:forEach items="${list}" var="item" >
			<tr>
				<td>${item.isbn}</td>
				<td class="title">${item.title}</td>
				<td>${item.catalogue}</td>
				<td>${item.author}</td>
			</tr>
		</c:forEach>
		</c:otherwise>
	</c:choose>
	</table>
	</div>
	<div id="ftresult">
	</div>
	<br>
	<a href="./book/Book.html">도서 등록</a>
	<a href="index.jsp">메인 페이지</a>
	
	<script type="text/javascript">
		$('.title').on("mouseover",function(){
			let title = $(this).html();
			
			
			$.ajax({
				type: "post",
				url: "findTitle.do",
				data:{
					"command":"findTitle",
					"title":title
				},
				success: function(result) {
					let str = result.split(",");
					$('#ftresult').html("<font color=crimson>Book 상세정보 출력 - 제목 : "+str[0]+", 출판사 : "+str[1]+", 저자 : "+str[2]+"</font>");
					
				}
				
			})
			
			
		})//on
	
	</script>
</body>

</html>