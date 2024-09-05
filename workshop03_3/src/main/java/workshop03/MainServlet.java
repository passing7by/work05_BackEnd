package workshop03;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		//0. 한글 패치
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//1. 폼값 받기
		String id =request.getParameter("id");
		String pass = request.getParameter("pass");

		//2, 3. dao를 호출하여 반환값 받았다 치고...
		User user = new User("kosta", "1234", "김코난", "종각");
		
		//4. request에 바인딩...결과페이지에서 폼값만 출력할거기 때문에 안 해도 됨
		request.setAttribute("user", user);
		
		//5. 서버 상에서 다이렉트로 다른 서블릿 혹은 제이에스피로 이동하는 방법
		if(id.equals(user.getId()) && pass.equals(user.getPass())) {
			//request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			out.println("<a href='loginSuccess.jsp'>Success Page 이동</a>");
			/*
			 * html에서 폼값 제출 -> 서블릿 동작 -> 결과페이지(a태그) //요청&응답(서블릿)
			 * a태그 클릭 -> 결과페이지(loginSuccess.jsp) //요청&응답(jsp)
			 * a태그를 타고 들어간 결과 페이지의 내용 : 'null님이 로그인 되었습니다'
			 * request 안의 정보를 응답 후 사라지기 때문에 이러한 결과가 도출됨
			 */
		}else {
			//rresponse.sendRedirect("loginError.jsp");
			out.println("<a href='loginError.jsp'>Success Page 이동</a>");
		}
	}

}
