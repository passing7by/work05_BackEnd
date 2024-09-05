package web.servlet.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.connector.Response;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/front.do")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//값 받기
		String command = request.getParameter("command");
		if(command.equals("subject")) {
			subject(request, response);
		}if(command.equals("company")) {
			company(request, response);
		}
	}



	private void subject(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		PrintWriter out = response.getWriter();
		
		String result = "빅데이터 | 파이썬 | 자바 | JDBC | 모델링";
		
		out.print(result);
		
	}
	
	private void company(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		String result = "<ul><li> Tomato System</li><br>"+
				"<li> NongDam System</li><br>"+
				"<li> ScowMan System</li></ul>";
		
		out.print(result);
	}

}
