package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;
import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;

public class FindTitleController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path="error.html";
		String title = request.getParameter("title");
		Book book = BookDAOImpl.getInstance().findTitle(title);
		if(book != null) {
			request.setAttribute("ftresult", book);
			
			path="FT_result.jsp";
		}
		return new ModelAndView(path);
		
	}

}
