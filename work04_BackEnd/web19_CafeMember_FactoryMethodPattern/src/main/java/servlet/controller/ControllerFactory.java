package servlet.controller;

public class ControllerFactory {
	
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() {
		System.out.println("ControllerFactory...Createing");
	}
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	// FrontController가 전해주는 command 값에 따라서 생성되는 Controller가 다르다.
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("find")) {
			controller = new FindController();
			System.out.println("FindController 생성..");
			
		}
		return controller;
	}
}
