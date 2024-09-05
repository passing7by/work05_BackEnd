package web.servlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CookieServlet")
public class CookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 쿠키 생성
				Cookie c1 = new Cookie("id", "kosta");
				Cookie c2 = new Cookie("today", "2024-08-29");
				Cookie c3 = new Cookie("erf", "hello");
				Cookie c4 = new Cookie("12", "2024-08-29");
				//키값이 중복될 경우 자체적으로 중복이 제거됨
				
				//쿠키 정보 저장 시간을 지정
				c1.setMaxAge(24*60*60); //하루 동안 저장
				c2.setMaxAge(24*60*60*2); //이틀 동안 저장
				
				//2. 클라이언트로 보냄
				response.addCookie(c1);
				response.addCookie(c2);
				response.addCookie(c3);
				response.addCookie(c4);
				
				//페이지 이동
				response.sendRedirect("getCookie.jsp");
	}

}
