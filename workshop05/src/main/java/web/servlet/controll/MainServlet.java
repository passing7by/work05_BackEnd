package web.servlet.controll;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Product;
import web.servlet.model.ProductDAOImpl;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 한글 패치
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		//1. 폼값 받기
		String prodName = request.getParameter("pName");
		int prodPrice = Integer.parseInt(request.getParameter("pPrice"));
		String prodDesc = request.getParameter("pDesc");
		
		Product pvo = null;
		
		if(prodDesc == null) {
			pvo = new Product(prodName, prodPrice);
		}else {
			pvo = new Product(prodName, prodPrice, prodDesc);
		}
		
		try {
			ProductDAOImpl.getInstance().register(pvo);
			response.sendRedirect("ListServlet");
		} catch (Exception e) {		
			System.out.println(e);
		}

	}

}
