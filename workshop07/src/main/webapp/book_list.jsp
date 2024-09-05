<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
    />
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>Insert title here</title>
    
    <style type="text/css">
    	.container{
	    	display: flex;
	    	flex-direction: column;
	    	align-items: center;
    	}
    	.container, #header{
    		width: 1000px;
    	}
    	#header{
    		padding: 0 20px;
    	}
    </style>
  </head>

  <body>
    <div class="container">
      <h2>도서 목록 화면</h2>
      <br />

      <form action="front.do" method="get">
        <input type="hidden" name="command" value="bookSearch" />
        <select name="select">
          <option value="all">전체</option>
          <option value="title">도서명</option>
          <option value="publisher">출판사</option>
          <option value="price">가격</option>
        </select>

        <input type="text" name="search" />
        <input type="submit" value="검색" />
      </form>
      
		
      <table class="table table-striped">
        <tr>
          <th>도서번호</th>
          <th>도서명</th>
          <th>도서분류</th>
          <th>저자</th>
        </tr>
        
        <c:choose>
          <c:when test="${select==all}">
            <c:forEach items="${list}" var="book">
              <c:if test="${fn:containsIgnoreCase(book, search)}">
                <tr>
                    <td>${book.isbn}</td>
                    <td>${book.title}</td>
                    <td>${book.catalogue}</td>
                    <td>${book.author}</td>
                </tr>
              </c:if>
            </c:forEach>
          </c:when>

          <c:when test="${select==title}">
            <c:forEach items="${list}" var="book">
              <c:if test="${fn:containsIgnoreCase(book.title, search)}">
                <tr>
                    <td>${book.isbn}</td>
                    <td>${book.title}</td>
                    <td>${book.catalogue}</td>
                    <td>${book.author}</td>
                </tr>
              </c:if>
            </c:forEach>
          </c:when>

          <c:when test="${select==publisher}">
            <c:forEach items="${list}" var="book">
              <c:if test="${fn:containsIgnoreCase(book.publisher, search)}">
                <tr>
                    <td>${book.isbn}</td>
                    <td>${book.title}</td>
                    <td>${book.catalogue}</td>
                    <td>${book.author}</td>
                </tr>
              </c:if>
            </c:forEach>
          </c:when>

          <c:when test="${select==price}">
            <c:forEach items="${list}" var="book">
              <c:if test="${fn:containsIgnoreCase(book.price, search)}">
                <tr>
                    <td>${book.isbn}</td>
                    <td>${book.title}</td>
                    <td>${book.catalogue}</td>
                    <td>${book.author}</td>
                </tr>
              </c:if>
            </c:forEach>
          </c:when>

          <c:otherwise>
            <c:forEach items="${list}" var="book">
                <tr>
                    <td>${book.isbn}</td>
                    <td>${book.title}</td>
                    <td>${book.catalogue}</td>
                    <td>${book.author}</td>
                </tr>
            </c:forEach>
          </c:otherwise>
        </c:choose>
      </table>
      <br>
      
      <a href="./book/Book.html">도서 등록</a>
      <br><br>
    </div>
    
    
  </body>
</html>

