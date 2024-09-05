package web.servlet.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.model.Member;
import web.servlet.model.MemberDAOImpl;


@WebServlet("/Allmember")
public class AllmemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * 0. 한글처리 (양방향)
		 * 1. 폼값을 받아서
		 * 2. DAO에 비지니스 로직 호출
		 * 3. DB 데이터 반환받아서 바인딩
		 * 4. 네비게이션
		 */
		try {
			ArrayList<Member> list = MemberDAOImpl.getInstance().showAllMember();
				request.setAttribute("list", list);
				request.getRequestDispatcher("allView.jsp").forward(request, response);
		}catch (SQLException e) {
		}
	}
}
