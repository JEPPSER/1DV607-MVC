package com.jesper.mvc.controller;

import java.util.ArrayList;

import com.jesper.mvc.model.Member;

/**
 * 
 * @author Oskar
 *
 */
public class ConsoleController {
	
	ArrayList<Member> memberList;
	
	MemberController memberCtrl;
	BoatController boatCtrl;
	
	public ConsoleController(/*Controller controller*/) {
		
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
