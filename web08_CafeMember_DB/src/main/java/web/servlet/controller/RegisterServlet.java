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


@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegisterServlet() {
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		}
		request.getRequestDispatcher(path).forward(request, response);
	}

}


