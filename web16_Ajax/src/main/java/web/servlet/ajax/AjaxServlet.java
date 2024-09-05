package web.servlet.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/front.do")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//폼값 받아서 1
		//dao 비지니스 로직 호출시 인자값으로
		//vo 반환값 받아서 바인딩 받았다 치고
		//네비게이션 결과페이지는 result.jsp 2
		
		request.getParameter("id");
		
		try {
			Thread.sleep(2000); //2초동안 잠이 듦 (cpu 점유권을 박탈당하고 잠깐 내려옴)
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
