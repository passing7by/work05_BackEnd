<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script type="text/javascript">
      $(function () {
        $("#AjaxBtn").on("click", () => {
          let id = $("#userId").val();

          //비동기 시작
          $.ajax({
            type: "post",
            url: "./members.json",
            data: { id: id },

            success: function (result) {
              //   alert(result.members.length);
              let members = result.members;
              let str = "";
              $.each(members, function (index, item) {
                // str += item.id;
                $("#resultView").append(
                  "<h3><font color=tomato>" + item.id + "</font></h3>"
                );
              });
              alert(str);
            }, //callback
          });
        });
      });
    </script>
  </head>

  <body>
    <h3>
      Form에 입력된 값을 서버로 보내고, 서버에서 보낸 값 받아서 페이지 부분 갱신
    </h3>
    id <input type="text" name="userId" id="userId" />
    <input type="button" value="AjaxBtn" id="AjaxBtn" />

    <!-- 이 영역에 데이터를 뿌림 -->
    <div id="resultView"></div>
  </body>
</html>
