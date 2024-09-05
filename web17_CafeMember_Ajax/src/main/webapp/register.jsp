<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <script>
      $(function () {
        $("#idCheck").on("click", () => {
          let id = $("#id").val();
          alert(id);
          $.ajax({
            //front.do?command=idCheck
            type: "get",
            url: "front.do?command=idCheck",
            data: {'id':id},
            //result값 받아서...그 값이 true / false 에 따라 출력되는 값이 달라짐
            success: function(result){
                if(result=='true'){
					$('#resultView').html('<h3><font color=crimson>사용 중인 id입니다</font></h3>')
                }else{$('#resultView').html('<h3><font color=blue>사용 가능한 id입니다</font></h3>')}
            }
            //true -> resultView 영역에 사용중인 id(붉은색) / false -> 사용가능 id(파란색)
          });
        });
      });
    </script>
  </head>

  <body>
    <h2>회원가입을 위해 정보를 입력해 주세요.</h2>
    <form action="front.do" method="post">
      <input type="hidden" name="command" value="register" />
      <!-- 히든 태그 추가 -->
      id <input type="text" name="id" required="required" id="id"/>
      <input type="button" value="중복확인" id="idCheck" />
      <span id="resultView"></span>
      <br />

      password <input type="text" name="password" required="required" /><br />
      name <input type="text" name="name" /><br />
      address <input type="text" name="address" /><br />
      <input type="submit" value="회원가입" />
    </form>
  </body>
</html>
