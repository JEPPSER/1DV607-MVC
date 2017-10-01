package com.jesper.mvc.controller;

/**
 * 
 * @author Oskar
 *
 */
public class ConsoleController {
	
	MemberController memberController;
	BoatController boatController;
	
	public ConsoleController(/*Controller controller*/) {
		this.memberController = new MemberController();
		this.boatController = new BoatController();
	}
	
	public void start() {
		int cmd = 0/*controller.getCommand()*/;
		while (true /*cmd = controller.getCommand()*/) {
			
			switch(cmd) {
			case 1:
				break;
			default:
				break;
			}
		}
	}
}
