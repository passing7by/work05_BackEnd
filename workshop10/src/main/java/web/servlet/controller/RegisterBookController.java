package web.servlet.controller;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;

public class RegisterBookController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String path="index.jsp";
		String isbn = "";
		String[] tlist=request.getParameterValues("bookNo");
		for(String s : tlist) {
			isbn+= s+"-";
		}
		isbn=isbn.trim().substring(0, isbn.length()-1);
		
		String title = request.getParameter("bookTitle");
		String catalogue = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publish_date = request.getParameter("bookDate");
		String publisher = request.getParameter("bookPublisher");
		String author = request.getParameter("bookAuthor");
		int price= Integer.parseInt(request.getParameter("bookPrice")) ;
		String currency = request.getParameter("bookPrice2");
		String description = request.getParameter("bookSummary");
		
		Book book = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price, description);
		
		try {
			BookDAOImpl.getInstance().registerBook(book);
			request.setAttribute("vo", book);
			request.setAttribute("msg", "책 정보가 정상적으로 저장되었습니다.");
			path="./book/book_result.jsp";
			
		}catch (SQLException e) {
			System.out.println(e);
			request.setAttribute("msg", "책 등록중 오류벌생....저장 실패!!");
			path="/error/Error.jsp";
		}
		
		
		return new ModelAndView(path);
	}

}
