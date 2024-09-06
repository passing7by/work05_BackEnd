<!-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> -->
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>

    <script src="https://code.jquery.com/jquery-latest.min.js"></script>

    <style>
      table * {
        border: 1px solid gray;
      }
    </style>
  </head>

  <body>
    <table>
      <tr>
        <th>번호</th>
        <th>상품이미지</th>
        <th>상품명</th>
        <th>상품가격</th>
        <th>수량</th>
        <th>삭제</th>
      </tr>

      <tr>
        <td>1</td>
        <td>상품이미지</td>
        <td>포도</td>
        <td id="prod-price">1000</td>
        <td>
          <input
            type="button"
            class="button-plus"
            onclick='count("plus")'
            value="+"
          />
          <div class="prod-quantity" value="0">0</div>
          <input
            type="button"
            class="button-minus"
            onclick='count("minus")'
            value="-"
          />
        </td>
        <td>삭제</td>
      </tr>

      <tr>
        <td>1</td>
        <td>상품이미지</td>
        <td>포도</td>
        <td id="prod-price">1000</td>
        <td>
          <input
            type="button"
            class="button-plus"
            onclick='count("plus")'
            value="+"
          />
          <div class="prod-quantity" value="0">0</div>
          <input
            type="button"
            class="button-minus"
            onclick='count("minus")'
            value="-"
          />
        </td>
        <td>삭제</td>
      </tr>

      <tr>
        <td colspan="6" id="totalPrice">0</td>
      </tr>
    </table>
  </body>
</html>

<script>
  //   function count(type) {

  // 	// const prodQuantity = this.closest(".prod-quantity");

  //     // 결과를 표시할 element
  //     const prodQuantity = document.querySelector(".prod-quantity");

  //     // 현재 화면에 표시된 값
  //     let currentNum = prodQuantity.innerText;

  //     // 더하기/빼기
  //     if (type === "plus") {
  //       currentNum = parseInt(currentNum) + 1;
  //     } else if (type === "minus") {
  //       currentNum = parseInt(currentNum) - 1;
  //     }

  //     // 결과 출력
  //     prodQuantity.innerText = currentNum;

  //     //<가격 업데이트>
  //     // 결과를 표시할 element
  //     const totalPrice = document.getElementById("totalPrice");

  //     // 상품 가격
  //     const prodPrice = document.getElementById("prod-price").innerText;
  //     // const prodPrice = $("#prod-price").text;
  //     alert(prodPrice);

  //     // 결과 출력
  //     totalPrice.innerText = currentNum * prodPrice;
  //     // totalPrice.text(currentNum * prodPrice);
  //   }
</script>
