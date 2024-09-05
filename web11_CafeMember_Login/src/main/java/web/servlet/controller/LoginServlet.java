package web.servlet.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 1. 폼값 받아와서
		 * 2. dao 호출
		 * 3. db 리턴받으면
		 * 4. 세션을 받아와서 세션에 바인딩(vo!=null)
		 * 5. 네비게이션
		 * 결과 페이지
		 * login_result.jsp
		 * 
		 * 
		 */
//		request.setCharacterEncoding("utf-8");
//		response.setContentType("text/html;cahtset=utf-8");
		
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		
		String path = "index.html";
		
		try {
			Member rvo = MemberDAOImpl.getInstance().login(id, pass);
			HttpSession session = request.getSession();
			/*
			 * session에 바인딩하는 경우
			 * 1. 로그인 로직
			 * 2. 정보수정 로직
			 */
			
			if(rvo!=null){
				session.setAttribute("vo", rvo);
				System.out.println("LoginServlet JsessionID : +"+session.getId());
				path = "login_result.jsp";
			}
			
		} catch (Exception e) {
			System.out.println(e);
			path = "login_fail.jsp";
		}
		request.getRequestDispatcher(path).forward(request, response);
		
	}

}
