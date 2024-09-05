package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterController implements Controller{
	private static RegisterController register = new RegisterController();
	private RegisterController(){}
	public static RegisterController getInstance() {
		return register;
	}
	
	@Override
	public String handle(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * 폼값 받기
		 * dao 리턴받아 비즈니스 로직 호출
		 * 데이터 바인딩
		 * 네비게이션
		 */
		System.out.println("RegisterController 비즈니스 로직 호출");
		return "";
	}
	
}
