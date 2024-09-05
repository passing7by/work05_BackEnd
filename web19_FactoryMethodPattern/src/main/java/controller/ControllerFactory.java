package controller;

public class ControllerFactory {
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory(){}
	public static ControllerFactory getFactory() {
		return factory;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("REGISTER")) {
			controller = RegisterController.getInstance();
			System.out.println("RegisterController 생성 완료");
		}else if (command.equals("LOGIN")) {
			controller = LoginController.getInstance();
			System.out.println("LoginController 생성 완료");

		}else if (command.equals("FIND")) {
			controller = FindController.getInstance();
			System.out.println("FindController 생성 완료");

		}else if (command.equals("REMOVE")) {
			controller = RemoveController.getInstance();
			System.out.println("RemoveController 생성 완료");

		}
		return controller;
	}
}
