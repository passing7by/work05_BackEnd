package web.servlet.controller;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;
import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;

public class showAllController implements Controller {
	
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String path="error.html";
		String type = "전체";
		String keyward="";
		
		if(request.getParameter("type")!=null) {
			type=request.getParameter("type");
			keyward=request.getParameter("keyward");
			
		}
		
		
		ArrayList<Book> list = BookDAOImpl.getInstance().showAllBook(type, keyward);
		request.setAttribute("list", list);
		path="book/booklist.jsp";
		return new ModelAndView(path);
		
	}

}
