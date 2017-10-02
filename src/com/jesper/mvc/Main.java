package com.jesper.mvc;

import com.jesper.mvc.view.ConsoleView;

public class Main {

	public static void main(String[] args) {
		ConsoleView cv = new ConsoleView();
		cv.displayCommands();
		while(true){
			cv.getInput();	
		}
	}
}
