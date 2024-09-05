package web.servlet.http;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/params")
public class ParameterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 한글처리..양방향
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//2. PrintWriter 객체 반환
		PrintWriter out = response.getWriter();
		
		//3. 폼값 받아서
		String job = request.getParameter("job");
		String pageNo = request.getParameter("pageNo");
		String searchWord = request.getParameter("searchWord");
		
		//4. 웹브라우저로 출력
		StringBuffer sb = new StringBuffer();
		sb.append("<h2> job : ").append(job).append("</h2>");
		sb.append("<h2> pageNo : ").append(pageNo).append("</h2>");
		sb.append("<h2> searchWord : ").append(searchWord).append("</h2>");
		
		out.println("<h2>get 방식으로 받은 정보 출력</h2>");
		out.println(sb);
		out.close();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 한글처리..양방향
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//2. PrintWriter 객체 반환
		PrintWriter out = response.getWriter();
		
		//3. 폼값 받아서
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		String[] hobbies = request.getParameterValues("hobby");
		StringBuilder sbHobby = new StringBuilder();
		for (int i = 0; i < hobbies.length; i++) {
			if(i<hobbies.length-1) {
				sbHobby.append(hobbies[i]).append(", ");
			}else {
				sbHobby.append(hobbies[i]);
			}
		}
		System.out.println(sbHobby);
		System.out.println(sbHobby.length());
		
		String favorite = request.getParameter("favorite");
		String desc = request.getParameter("desc");
		
		//4. 웹브라우저로 출력
		StringBuilder sb = new StringBuilder();
		sb.append("<h3>name : ").append(name).append("</h3>");
		out.append(sb);
		out.close();
	}

}
