package web.http.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FS")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 

    public FormServlet() { }
    
    //클라이언트의 요청이 서버상으로 들어오면 doGet() 함수가 컨테이너에 의해서 호출됨
    //이때 폼에 입력된 값이 요청정보(request)를 타고 서버로 전달됨
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 폼에 입력된 값 id, pass 값을 받아온다...id, pass에서 변수명 받아오기
		String id = request.getParameter("userId"); //request.getParameter("input 태그의 name 속성에 있는 값")
		String pass = request.getParameter("userPass");
		
		//2. 받아온 값을 브라우저로 출력
		//   * id : kosta
		//   * pass : 1234
		PrintWriter out = response.getWriter();
		out.println("<html><body><h3>");
		out.println("<ul><li>id : "+id+"</li>");
		out.println("<li>pass : "+pass+"</li></ul>");
		out.println("</h3></body></html>");

		
	}

}
