<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-latest.min.js"></script>

    <style>
      * {
        /* border: 1px solid gray; */
        box-sizing: border-box;
        margin: 0;
      }
      body {
        display: flex;
        flex-direction: column;
        align-items: center;
      }
      h1 {
        color: dodgerblue;
        margin: 30px 0;
      }
      #item-list {
        width: 1200px;
        display: flex;
        justify-content: space-between;
      }
      .item {
        width: 200px;
        height: 300px;
      }
      img {
        width: 200px;
        height: 200px;
        object-fit: fill;
        border: 4px solid dodgerblue;
        border-radius: 11px;
      }
      img:hover {
        border: 4px solid rgb(270, 60, 71);
      }
      .item-info * {
        margin: 17px 0;
      }
    </style>

    <script>
      $(function () {
        $("img").on("click", function () {
          let id = "";
          id = $(this).attr("data-id");
          // alert(id);
          location.href = "itemView.do?id=" + id;
        });
      });
    </script>
  </head>

  <body>
    <h1>Fruit Total List 1.</h1>
    <br />
    <div id="item-list">
      <c:forEach items="${list}" var="item">
      	<div class="item">
	        <img class="item-img" src="${item.url}" data-id="${item.itemNumber}" />
	        <div class="item-info">
	          <p class="item-name">상품명 : ${item.name}</p>
	          <p class="item-price">가격 : ${item.price}</p>
	        </div>
      	</div>
      </c:forEach>
    </div>
  </body>
</html>
