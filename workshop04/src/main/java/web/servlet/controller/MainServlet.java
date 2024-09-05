package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.vo.Product;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 한글 패치
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		//1. 폼값 받기
		String pName = request.getParameter("pName");
		int pPrice = Integer.parseInt(request.getParameter("pPrice"));
		String pDesc = request.getParameter("pDesc");
		
		//2, 3. dao 호출해서 반환값 받았다고 치고...
		Product product = new Product("1", pName, pPrice, pDesc);
		
		//4. 바인딩 (결과페이지에서 폼값 와의 반환값을 출력할 것이기 때문에)
		request.setAttribute("product", product);
		
		//5. 네비게이션
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

}
