package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;

public class LoginController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		String path="loginError.jsp";
		try {
			User user = UserDAOImpl.getInstance().login(id, pass);
			if(user != null) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				path="loginSuccess.jsp";
			}
		}catch (SQLException e) {
			System.out.println(e);
			path="loginError.jsp";
			
		}return new ModelAndView(path);
		
	}

}
