package web.factory;

import javax.security.auth.login.LoginContext;

import web.controller.Controller;
import web.controller.FindController;
import web.controller.LoginController;
import web.controller.RegisterController;
import web.controller.UpdateController;

/*
 * Controller를 만드는 공장
 * 이곳에서 RegisterController, FindController, Update~, Login~를 각각 생성한다.
 * 
 * 1) 4개의 Controller 생성 --> ControllerFactory 4개 필요?
 * 2) 4개의 Controller 생성 --> Contr
 * 
 * -> ControllerFactory 싱글톤 패턴으로 작성
 */

public class ControllerFactory {
	
	private static ControllerFactory factory = new ControllerFactory();
	private ControllerFactory() {
		System.out.println("Creating ControllerFactory...");
	}
	
	public static ControllerFactory getInstance() {
		return factory;
	}
	
	public Controller createController(String command) {
		Controller controller = null;
		if(command.equals("register")) {
			controller = new RegisterController();
			System.out.println("register complete");
		} else if(command.equals("find")) {
			controller = new FindController();
			System.out.println("find complete");
		} else if(command.equals("update")) {
			controller = new UpdateController();
			System.out.println("update complete");
		} else if(command.equals("login")) {
			controller = new LoginController();
			System.out.println("login complete");
		}
		
		
		return controller;
	}
}
