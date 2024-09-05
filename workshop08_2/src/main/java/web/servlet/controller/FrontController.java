package web.servlet.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Book;
import web.servlet.model.BookDAOImpl;
import web.servlet.model.User;
import web.servlet.model.UserDAOImpl;

@WebServlet("/front.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String path = "index.html";
		
		switch (command) {
		case "login":
			path=login(request, response);
			break;
		case "logout":
			path=logout(request, response);
			break;
		case "addBook":
			path=addBook(request, response);
			break;
		case "bookList":
			path=bookList(request, response);
			break;
		case "bookSearch":
			path=bookSearch(request, response);
			break;
		case "showDesc":
			showDesc(request, response);
			return;
		}

		request.getRequestDispatcher(path).forward(request, response);
	}//doProcess
	
	private void showDesc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;cahtset=utf-8");
		PrintWriter out = response.getWriter();

		//폼값 받아서
		String isbn = request.getParameter("isbn");
		Book book = null;
		//비지니스 로직 호출...true/false... boolean idExist(id)
		
		try {
			book = BookDAOImpl.getInstance().findBook(isbn);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		 //여기서 응답 부분으로 날아감...data 부분에 담김
		out.print("title: "+book.getTitle()+" publisher: "+book.getPublisher()+" author: "+book.getAuthor());
	}

	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String path = "loginError.jsp";

		//1. 폼값 받기
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		
		//2. dao 리턴받아 비지니스 로직 호출
		try {
			User user = UserDAOImpl.getInstance().login(id, pass);
			
			if(user!=null) {
			HttpSession session = request.getSession(); //로그인하기 위해 세션을 받아와서 변수에 할당
			session.setAttribute("user", user);
			path = "loginSuccess.jsp";
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return path;
	}//login
	
	private String logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String path = "login.html";
		
		HttpSession session = request.getSession(); //로그아웃하기 위해 세션을 받아와서 변수에 할당
		User user = (User)session.getAttribute("user");
		if(user!=null) {
			session.invalidate();
		}
		
		return path;
	}//logout
	
	private String addBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String path = "error.jsp";
		
		//1. 폼값 받기
		String[] isbns = request.getParameterValues("bookNo");
		
		String isbn = isbns[0]+"-"+isbns[1]+"-"+isbns[2];
		String title = request.getParameter("bookTitle");
		String catalogue = request.getParameter("bookCategory");
		String nation = request.getParameter("bookCountry");
		String publish_date = request.getParameter("bookDate");
		String publisher = request.getParameter("bookPublisher");
		String author = request.getParameter("bookAuthor");
		int price = Integer.parseInt(request.getParameter("bookPrice"));
		String currency = request.getParameter("bookPrice2");
		String description = request.getParameter("bookNo");
		
		Book book = new Book(isbn, title, catalogue, nation, publish_date, 
							 publisher, author, price, currency, description);
		
		//2. dao 리턴받아 비지니스 로직 호출
		try {
			BookDAOImpl.getInstance().registerBook(book);
			User user = (User)request.getSession().getAttribute("user");
			
			if(user!=null){
				request.setAttribute("book", book);
				request.setAttribute("msg", "책 정보가 정상적으로 저장되었습니다.");
				path = "book_success.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "책 등록 중 오류가 발생했습니다. 책 정보가 저장되지 못했습니다.");
		}
		
		return path;
	}//addBook
	
	private ArrayList<Book> getAllBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException{
		ArrayList<Book> list = BookDAOImpl.getInstance().showAllBook();
		request.setAttribute("list", list);
		
		return list;
	}
	
	private String bookList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String path = "index.html";
		
		//2. dao 리턴받아 비지니스 로직 호출
		try {
			HttpSession session = request.getSession(); //로그인하기 위해 세션을 받아와서 변수에 할당
			User user = (User)session.getAttribute("user");
			
			if(user!=null){
				getAllBook(request, response);
				path = "book_list.jsp";
			}
		} catch (SQLException e) { 
			e.printStackTrace();
		}
		
		return path;
	}//bookList
	
	private String bookSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String path = "book_list.jsp";
		
		//1. 폼값 받기
		String option = request.getParameter("option");
		String search = request.getParameter("search");
				
		request.setAttribute("option", option);
		request.setAttribute("search", search);
		
		try {
			getAllBook(request, response);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return path;
	}//bookSearch
}
