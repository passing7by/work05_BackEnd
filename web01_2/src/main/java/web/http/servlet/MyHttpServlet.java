package web.http.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * @ 어노테이션 기법
 * 컨테이너가 .xml 파일을 찾다가 없으면 어노테이션을 읽고 트랜스폼(주문서, 즉 스스로 .xml을 만들어 냄)
 */
@WebServlet("/SS")
public class MyHttpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public MyHttpServlet() {
    	System.out.println("1. 서블릿 객체 생성...by container");
    	//이 부분이 콘솔창에 떳다는 것은 컨테이너가 생성자를 호출하여 객체를 생성햇다는 뜻
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.println("<html><body><h2>"); //브라우저로 () 안에 있는 내용을 출력	
		out.println("Hi Servlet~!");
		out.println("</h2></body></html>"); //브라우저로 () 안에 있는 내용을 출력	
	}

}
