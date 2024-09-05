<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>

    <style>
      * {
        /* border: 1px solid gray; */
        margin: 0;
        box-sizing: border-box;
      }
      body {
        max-width: 1200px;
        margin: 20px auto;
        display: flex;
        flex-direction: column;
      }
      h1 {
        text-align: center;
        margin-bottom: 25px;
      }
      #menu {
        display: flex;
        justify-content: right;
        background: orange;
      }
      #menu > * {
        margin: 5px 20px;
      }
      #item-detail {
        display: flex;
        margin: 20px;
      }
      #item-detail > * {
        width: 50%;
        min-width: 510px;
      }
      #item-img {
        position: static;
      }
      img {
        object-fit: fill;
        width: 500px;
        height: 500px;
        position: relative;
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
      }
      #item-info * {
        margin: 20px;
      }
      #toItemList {
        text-align: center;
      }
    </style>
  </head>

  <body>
    <h1>${item.name} 정보</h1>

    <div id="menu">
      <h4 id="count">조회수:${item.count}</h4>
      <a href="#"><h4 id="addCart">장바구니 담기</h4></a>
      <a href="#"><h4 id="toCart">장바구니 확인</h4></a>
    </div>

    <div id="item-detail">
      <div id="item-img">
        <img id="item" src="${item.url}" />
      </div>
      <div id="item-info">
        <p id="item-name">종 류 : ${item.name}</p>
        <p id="item-price">가 격 : ${item.price}</p>
        <p id="item-desc">설 명 : ${item.description}</p>
      </div>
    </div>

    <div id="toItemList">
      <a href="itemList.jsp"><h4>상품 목록 가기</h4></a>
    </div>
  </body>
</html>
