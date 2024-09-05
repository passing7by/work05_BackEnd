package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;

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
		//로직은 여기서 작성....한글처리 안해도 됨...Filter 등록되어 있음
		//command값 받아오기
		
		String command = request.getParameter("command");
		String path = "index.html";
		
		if(command.equals("find")) {
			path=find(request, response);
		}else if(command.equals("login")) {
			path=login(request, response);
		}else if(command.equals("register")) {
			path=register(request, response);
		}else if(command.equals("showAll")) {
			path=showAll(request, response);
		}
		request.getRequestDispatcher(path).forward(request, response);
		//QUESTION : redirect 방식은 어떻게?
	}//doProcess
	
	//아래의 모든 메소드에서 네비게이션이 계속 반복됨 -> 하나로 합칠 필요성이 있음
	private String find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String path = "find_fail.jsp";

		try {
			Member rvo = MemberDAOImpl.getInstance().findByIdMemer(id);
			if(rvo != null) {
				request.setAttribute("vo", rvo);
				path="find_ok.jsp";
			}
		}catch (SQLException e) {
			e.getMessage();
		}
		
		return path;
	}
	private String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		String pass = request.getParameter("password");
		
		String path = "index.html";
		
		try {
			Member rvo = MemberDAOImpl.getInstance().login(id, pass);
			HttpSession session = request.getSession();
			/*
			 * session에 바인딩하는 경우
			 * 1. 로그인 로직
			 * 2. 정보수정 로직
			 */
			
			if(rvo!=null){
				session.setAttribute("vo", rvo);
				System.out.println("LoginServlet JsessionID : +"+session.getId());
				path = "login_result.jsp";
			}
			
		} catch (Exception e) {
			e.getMessage();
			path = "login_fail.jsp";
		}
		
		return path;
	}
	private String register(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String address = request.getParameter("address");
		
		Member pvo = null;
		
		if(name.equals("") || address.equals("")) {
			pvo = new Member(id, password);
		}else {
			pvo = new Member(id, password, name, address);
		}
		
		String path = "index.html";

		try {
			MemberDAOImpl.getInstance().registerMenber(pvo);
			path = "register_result.jsp";
			request.setAttribute("vo", pvo);

		}catch (SQLException e) {
			e.getMessage();
		}
		
		return path;
	}
	private String showAll(HttpServletRequest request, HttpServletResponse response) {
		String path = "index.html";
		
		try {
			ArrayList<Member> list = MemberDAOImpl.getInstance().showAllMember();
				request.setAttribute("list", list);
				path = "allView.jsp";
		}catch (SQLException e) {
			e.getMessage();
		}
		
		return path;
	}

}
