package web.servlet.greet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GreetServlet extends HttpServlet{
	private String greet = ""; //ready on 시점에 값 받아옴...클라이언트 요청과는 무관
	private String name = ""; //클라이언트 요청시에 폼값
	
	public GreetServlet() {
		System.out.println("1. 서블릿 생성");
		System.out.println("test...greet : "+greet+" name : "+name);
	}
	
	@Override
	public void init() throws ServletException {
		System.out.println("2. 서블릿컨피그 생성 & init() 호출");
		
		greet = getInitParameter("greet"); //필드 초기화
		System.out.println("test...greet : "+greet+" name : "+name);
		System.out.println("greet message :: "+greet);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//한글 데이터 처리
		request.setCharacterEncoding("utf-8"); //요청 시의 정보 인코딩
		response.setContentType("text/html;charset=utf-8");//응답 시의 정보 인코딩
		
		System.out.println("3. 클라이언트 요청시 호출...폼값을 받아옴");
		
		PrintWriter out = response.getWriter();
		name = request.getParameter("name"); //필드 초기화
		System.out.println("test...greet : "+greet+" name : "+name);
		
		out.println("<html><body><h3>");
		out.println(name+", "+greet);
		out.println("</h3></body></html>");
		
		out.close();
	}
}
