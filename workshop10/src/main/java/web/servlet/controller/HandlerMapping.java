package web.servlet.controller;

//Component를 생성한는 일종의 공장
//서블릿이 전해주는 command값에 따라서 Component를 생성
//그리고 다시 서블릿에게 생성한 Component를 반환할 때는 Controller 인터페이스 타입으로 반환 

public class HandlerMapping {
	private static HandlerMapping factory = new HandlerMapping();
	private HandlerMapping() {}
	public static HandlerMapping getFactory() {
		return factory;
	}
	//Component를 생성하는 기능...
	public Controller createComponent(String command) {
		Controller controller = null;
		if(command.equals("login.do")) {
		 controller = new LoginController();
		}else if(command.equals("register.do")) {
			controller = new RegisterBookController();
		}else if(command.equals("showAll.do")) {
			controller = new showAllController();
		}else if(command.equals("logout.do")) {
			controller = new LogoutController();
		}else if(command.equals("findTitle.do")) {
			controller = new FindTitleController();
		}
		
		return controller;
	}
	
	
}
