<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script type="text/javascript">
      $(function(){
        //버튼 클릭하면 함수 호출
        $("#ajax").on("click", () => {
          //비동기 통신 시작
          $.ajax({
            //요청 부분
            type: "get",
            url: "http://localhost:8888/web16_Ajax/bank.json",

            //응답 부분 (결과 페이지가 없이, 이 부분으로 응답됨)
            success: function (resultData) {
              //데이터를 성공적으로 받았을 때만 응답한다는 뜻
              alert(resultData.data);
            },
            error: function (e) {
              alert(e + "...응답 시간이 너무 지연됩니다. 다시 시도해주세요.");
            },
            timeout: 1000, //1초동안 서버로부터 응답이 없으면 Error 발생(응답 시간 지정 가능)
            //callback
          });
        }); //on
      }); //onload
    </script>
  </head>

  <body>
    <h3>버튼 클릭시 비동기 통신 시작</h3>
    <input type="button" value="JQuery Ajax" id="ajax" />
  </body>
</html>
