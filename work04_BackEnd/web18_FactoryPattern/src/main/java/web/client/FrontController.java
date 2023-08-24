package web.client;

import java.util.Scanner;

import web.controller.Controller;
import web.factory.ControllerFactory;

public class FrontController {
/*
 * 나중에 서블릿 역할
 * FrontController가 된다.
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(">>>>Command 값 입력..");
		String command = sc.next();
		
		Controller controller =  ControllerFactory.getInstance().createController(command);
		controller.handleRequest();
	}

}
