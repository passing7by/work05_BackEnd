package web.servlet.controller;

import java.io.IOException;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;
import web.servlet.model.User;
@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, description
		
		
		String[] isbns = request.getParameterValues("bookNo");
		System.out.println(isbns);
		
		String isbn = isbns[0]+"-"+isbns[1]+"-"+isbns[2];
		System.out.println(isbn);

		
		String title = request.getParameter("bookTitle");
		String catalogue = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publish_date = request.getParameter("bookDate");
		String publisher = request.getParameter("bookPublisher");
		String author = request.getParameter("bookAuthor");
		int price = Integer.parseInt(request.getParameter("bookPrice"));
		String currency = request.getParameter("bookPrice2");
		String description = request.getParameter("bookNo");
		//폼값 받아서
		
		Book book = new Book(isbn, title, catalogue, nation, publish_date, publisher, author, price, currency, description);
		User user = (User)request.getSession().getAttribute("user");
		
		String path = "error.jsp";
		
		try {
			BookDAOImpl.getInstance().registerBook(book);
			HttpSession session = request.getSession();
			System.out.println("BookServlet JsessionID : "+session.getId());
			
			if(user!=null){
				request.setAttribute("book", book);
				path = "book_success.jsp";
				request.getRequestDispatcher(path).forward(request, response);
			}
		} catch (Exception e) {
			System.out.println(e);
			response.sendRedirect(path);

		}
		
	}
}
