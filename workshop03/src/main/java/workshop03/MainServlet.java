package workshop03;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		//4. request에 바인딩...결과페이지에서 폼값만 출력할거기 때문에 안 해도 됨
//		request.setAttribute("user", user);
		
		//5. 서버 상에서 다이렉트로 다른 서블릿 혹은 제이에스피로 이동하는 방법
		if(id.equals(user.getId()) && pass.equals(user.getPass())) {
			request.getRequestDispatcher("loginSuccess.jsp").forward(request, response);
			//결과페이지에서 request에 들어있는 정보를 출력해야하기 때문에
		}else {
			response.sendRedirect("loginError.jsp");
			//결과페이지에서 request에 들어있는 정보를 출력하지 않기 때문에
		}
	}

}
