package web.servlet.page;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Redirect2")
public class ChoiceRedirect2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼값 받아서
		 * 2. 에러 발생 여부에 따라서 페이지 이동법을 달리한다
		 * 	  1) 에러 발생하는 경우 (선택하지 않으면)...에러페이지로 연결 --> Redirect 방식으로 페이지 이동
		 * 	  2) 에서 발생하지 않는 경우...redirect2.jsp 페이지로 연결 --> Forward 방식으로 이동
		 */
		
		//0. 한글 패치
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1. 폼값 받기
		String[] cities = request.getParameterValues("city");
		//도시를 중복선택 가능하기 때문에 (하나의 input 네임에 두개 이상의 값이 들어갈 수 있기 때문에)
		//request.getParameterValues()로 폼값을 가져옴(리턴타입 : String 배열)
		
		
		//2. 에러 핸들링 & 네비게이션
		if(cities!=null) { //하나라도 선택했다면
			for (String s : cities) {
				System.out.println(s);
			}
			//이 부분은 스스로 추가한 부분인데...
			//if(cities!=null) {} 밖에다 놓으면 cities==null일 때 NullPointerException을 던짐...
			request.getRequestDispatcher("redirect2.jsp").forward(request, response);
			//해당 장소로 네비게이션
			//결과 페이지에서 앞서 받았던 폼값 외에는 출력하지 않을거기 때문에 바인딩하지 않음
		}else {
			response.sendRedirect("./error/error2.html");
			//해당 장소로 네비게이션
			//값을 가져가는 것도 없이 페이지만 이동할 것이기 때문에, response.sendRedirect()로
		}
	}
	

}
