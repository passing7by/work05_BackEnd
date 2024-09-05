package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.User;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 한글 패치
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1. 폼값 받기
		String id =request.getParameter("id");
		String pass = request.getParameter("pass");
		
		//2, 3. dao를 호출하여 반환값 받았다 치고...
		User user = new User("kosta", "1234", "김코난", "종각");
		
		//4. request에 바인딩
		request.setAttribute("user", user);
		
		//5. 서버 상에서 다이렉트로 다른 서블릿 혹은 제이에스피로 이동하는 방법
		if(id.equals(user.getId()) && pass.equals(user.getPass())) {
			request.getRequestDispatcher("LoginSuccess").forward(request, response);
		}else {
			request.getRequestDispatcher("LoginError").forward(request, response);
		}
	}

}
