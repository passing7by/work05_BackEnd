package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;

@WebServlet("/Find")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼값 받음
		 * 2. dao 비즈니스 로직호출...이 때 폼값을 인자값으로
		 * 3. 디비 반환값 받아서
		 * 4. 바인딩...setAttribute()
		 * 5. 네비게이션
		 * 
		 * ~ 혼자 다시 정리한 내용 ~
		 * 1. request에 저장되어 있는 폼값을 받음 (request.getParameter())
		 * 2. dao를 반환받아 비즈니스 로직 호출
		 * 	  (이 때, 1번을 인자값으로 전달, dao는 db와 접촉하여 비즈니스 로직 수행)
		 * 3. 반환값을 받음
		 * 	  (비즈니스 로직을 호출한 결과로 반환값이 있다면) 
		 * 4. 바인딩 (request.setAttribute())
		 * 	  (결과 페이지에서 폼값이 아닌 반환값을 통해 정보를 출력해야 한다면)
		 * 5. 네비게이션 : 페이지 이동 (request.getRequestDispatcher().forward())
		 */
		
		//0. 한글패치
		request.setCharacterEncoding("utf-8"); //요청 정보 인코딩
		response.setContentType("text/html;charset=utf-8"); //응답 정보 인코딩
		
		//1. request에 저장되어 있는 폼값을 받음
		//	 이 코드에서는 받은 폼값을 'address' 변수에 할당하고 있음
		//	 이때, request.getParameter()에서 () 안의 값은 input태그의 name 속성의 값이며,
		// 	 	  반드시 ""을 사용하여 String 값으로 넣어주어야 함
		String address = request.getParameter("address");
		
		//2, 3이 이루어져서 Member 객체를 반환받앗다고 가정...
		Member mem = new Member("홍종각", 33, "종각");
		
		//4. 바인딩 (결과페이지에서 폼값 외의 mem에 대한 정보들을 출력해야 하기 때문)
		request.setAttribute("mem", mem);
		
		//5. 네비게이션
		// 	 서버 상에서 다이렉트로 다른 서블릿??? 혹은 jsp로 이동하는 방법
		request.getRequestDispatcher("result.jsp").forward(request, response);
		
		
	}

}