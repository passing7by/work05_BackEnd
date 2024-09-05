package web.servlet.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web.servlet.vo.Product;

@WebServlet("/List")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Product> list;
	//필드 추가 
       
	public ListServlet() {
		list = new ArrayList<Product>();
		//생성자 안에서 필드 초기화
		//QUESTION : 근데 원래 서블릿 생성자에서 필드 초기화 안 되지 않나...?
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//0. 한글패치 - 안해도 됨 (폼값을 받아서 응답하는게 아니기 때문)
		
		//1. 폼값 받기 - 폼값을 받아서 동작하는 서블릿이 아님
		
		//2, 3. dao 호출해서 반환값 받았다 치고...
		Product p1 = new Product("2", "얍", 10000, "A++");
		Product p2 = new Product("3", "BBB", 11000, "B++");
		Product p3 = new Product("4", "CCC", 12000, "C++");
		
		list.add(p1);
		list.add(p2);
		list.add(p3);
		
		//4. 바인딩
		request.setAttribute("list", list);
		
		//5. 네비게이션
		request.getRequestDispatcher("list.jsp").forward(request, response);
	}

}
