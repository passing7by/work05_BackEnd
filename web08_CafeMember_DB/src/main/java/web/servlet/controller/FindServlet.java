package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;


@WebServlet("/Find")
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//get 방식 요청을 처리
		doProcess(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post 방식 요청을 처리
		doProcess(request,response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로직은 여기서 작성
		/*
		 * 0. 한글처리 (양방향)
		 * 1. 폼값을 받아서
		 * 2. DAO에 비지니스 로직 호출
		 * 3. DB 데이터 반환받아서 바인딩
		 * 4. 네비게이션
		 */
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;cahtset=utf-8");
		
		//폼값 받아서
		String id = request.getParameter("id");
		String path = "find_fail.jsp";

		try {
			Member rvo = MemberDAOImpl.getInstance().findByIdMemer(id);
			if(rvo != null) {
				request.setAttribute("vo", rvo);
				path="find_ok.jsp";
			}
		}catch (SQLException e) {
		}
		request.getRequestDispatcher(path).forward(request, response);
	}
}
