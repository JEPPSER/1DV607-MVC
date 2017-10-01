package com.jesper.mvc.controller;

import com.jesper.mvc.persistence.Database;

/**
 * 
 * @author Oskar
 *
 */
public class ConsoleController {
	
	Database database;
	MemberController memberController;
	BoatController boatController;
	
	public ConsoleController(/*Controller controller*/) {
		this.database = new Database();
		this.memberController = new MemberController(this.database);
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
