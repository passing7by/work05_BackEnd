package servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import servlet.model.Member;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		
		//DAO리턴 받아서 비지니스 오직 호출... VO 반환했다 치고
		Member rvo = new Member(id, pass, "홍종각", "종각");
		
		//바인딩...세션...얻어와야 함
		//클라이언트가 요청하는 순간 req, res와 함께 서버상에 만들어짐
		//세션 안에는 클라이언트(브라우저)를 구분하기 위한 고유한 값이 있음...JsessionID....getID()로 받아올 수 잇음
		HttpSession session = request.getSession();
		System.out.println("LoginServlet의 JsessionID : "+ session.getId());
		
		session.setAttribute("vo", rvo);
		
		//네비게이션
		response.sendRedirect("BuyServlet");
	}

}
