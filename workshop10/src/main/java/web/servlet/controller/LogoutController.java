package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;

public class LogoutController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path="login.html";
		HttpSession session = request.getSession();
		if(session.getAttribute("user")!=null) {
			session.invalidate();
			path="logout.jsp";
		}
		return new ModelAndView(path);
		
	}

}
