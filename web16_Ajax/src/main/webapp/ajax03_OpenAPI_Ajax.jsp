<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link
      rel="stylesheet"
      href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
    />
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
    <!-- 주의... 내가 붙여넣은 JQuery cdn 과 붓스트랩 JQuery cdn 이렇게 두 번 들어가게 되면 충돌남 -->
    <!-- 내가 붙여넣은 JQuery cdn 만 남기고 붓스트랩 JQuery cdn은 삭제 -->
    <script type="text/javascript">
      $(function () {
        $("#serverSend").on("click", () => {
          $.ajax({
            type: "get",
            url: "http://localhost:8888/weather.xml", //톰캣 홈 > webapps > root에 있는 weather.xml에 접근
            dataType: "xml",
            //서버에서 응답하는(내가 요청해야 하는) 데이터 타입을 미리 알려주는 속성 - optional 하지만 특이한 타입이 올 때는 명시하는 게 좋음

            success: function (result) {
              //   alert(result);
              //공공데이터를 받아올 때는, 내 프로젝트와 상관없이 was 에 가져다놓은 다음, 받아오는 프로그램을 만들어서 받아옴

              //xml은 반복되는 구간을 우리가 찾아와야 함
              let str = "";
              $(result)
                .find("list") //list가 4개 찾아짐
                .each(function (index, item) {
                  let region = $(this).find("region").text();
                  let wind = $(this).find("wind").text();
                  let rain = $(this).find("rain").text();
                  let temp = $(this).find("temp").text();

                  str += "<tr>";
                  str += "<td>" + region + "</td>";
                  str += "<td>" + wind + "</td>";
                  str += "<td>" + rain + "</td>";
                  str += "<td>" + temp + "</td>";
                  str += "</tr>";
                  // $("tbody").append(str); //append 사용 시에는 on 대신 one 사용
                }); //each

              //   $("tbody>tr*").remove(); //one 사용 시에는 이 부분을 지정하고 사용
              $("tbody").html(str);
            }, //success
          }); //ajax
        }); //on
      }); //onload
    </script>
  </head>

  <body>
    <div class="container">
      <div>
        <h2 align="center" class="jumbotron text-center">
          ========= open api weather 데이터 가져오기 ==========
        </h2>
      </div>
      <p><a href="#" id="serverSend">xml 데이터 서버로 요청하기</a></p>
      <table class="table table-hover">
        <thead class="thead-dark">
          <tr>
            <th>region</th>
            <th>wind</th>
            <th>rain</th>
            <th>temp</th>
          </tr>
        </thead>

        <tbody>
          <!-- 이 부분에 공공데이터 xml의 태그 안의 내용이 출력 $.each -->
        </tbody>
      </table>
    </div>
  </body>
</html>
