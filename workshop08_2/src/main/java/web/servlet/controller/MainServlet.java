package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;


/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/Login")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String id =request.getParameter("id");
		String pass = request.getParameter("pass");

		String path = "error.jsp";
		
		try {
			User user = UserDAOImpl.getInstance().login(id, pass);
			HttpSession session = request.getSession();
			System.out.println("MainServlet JsessionID : "+session.getId());
			
			if(user!=null){
				session.setAttribute("user", user);
				path = "loginSuccess.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect(path);
		}
	}
}
