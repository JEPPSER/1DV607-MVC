package com.jesper.mvc.controller;

import com.jesper.mvc.model.Member;
import com.jesper.mvc.persistence.Database;

/**
 * 
 * @author Oskar
 *
 */
public class ConsoleController {
	
	private Database database;
	private MemberController memberController;
	private BoatController boatController;
	
	/**
	 * 
	 */
	public ConsoleController(/*Controller controller*/) {
		this.database = new Database();
		this.memberController = new MemberController(this.database);
		this.boatController = new BoatController(this.database);
	}
	
	/**
	 * 
	 */
	public void start() {
		int cmd = 0/*controller.getCommand()*/;
		while (true /*cmd = controller.getCommand()*/) {
			
			switch(cmd) {
			case 1: /* View All Members */
				{
					int total = this.database.getTotalMembers();
					for (int i = 0; i < total; i++) {
						this.memberController.view(i);
					}

					break;
				}
			case 2: /* View All Members Verbose */
				{
					int total = this.database.getTotalMembers();
					
					for (int i = 0; i < total; i++) {
						this.memberController.viewVerbose(i);
					}
					
					break;
				}
			case 3: /* Create Member */
				{
					//TODO: Create New Member Object..
					
					this.memberController.create(new Member());
					break;
				}
			case 4: /* Update Member */
				{
					//TODO: inpuit for member id and values to update to..
					
					this.memberController.update(0, new Member());
					break;
				}
			case 5:
				// Delete Member
				break;
			case 6:
				// View Member
				break;
			case 7:
				// Create Boat
				break;
			case 8:
				// Update Boat
				break;
			case 9:
				// Delete Boat
				break;
			case 10:
				// View Boat
				break;
			default:
				break;
			}
		}
	}
}
