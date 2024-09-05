package web.generic.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class MyGenericServlet extends GenericServlet{
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	//req - 요청 정보를 담는 객체
	//res - 응답할 정보를 담는 객체...브라우저로 출력
	PrintWriter out = res.getWriter();
	out.println("<html><body><h2>"); //브라우저로 () 안에 있는 내용을 출력	
	out.println("Hi Servlet~!");
	out.println("</h2></body></html>"); //브라우저로 () 안에 있는 내용을 출력	
	
	//결과 : 404 - 페이지가 없거나, 경로가 잘못 됐거나...경로가 잘못되진 않았음 -> WAS에 인스턴스가 만들어지지 않은 것
	//톰캣 홈의 웹앱에 컨텍스트 패스 자체가 없음 - 톰캣 서버 경로 지정
	//그래도 안됨 - 톰캣에 클래스 파일은 생성되어 있음 - 근데 왜 안됨? 인스턴티에이션이 안 된 것
	//즉, 객체를 안 만든 것 - 컨테이너가 만들어야 함. 지금은 컨테이너가 못 만든 것
	//내가 주문서를 작성하고, 컨테이너가 그걸 보고 만들어야 함
	//즉, 내가 객체를 못 만들고 객체를 만들어달라는 주문서를 컨테이너에게 넘겨주어야 함
	}
}