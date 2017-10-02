package com.jesper.mvc;

import com.jesper.mvc.controller.ConsoleController;
import com.jesper.mvc.view.ConsoleView;

public class Main {

	public static void main(String[] args) {
		ConsoleView console = new ConsoleView();
		ConsoleController consoleController = new ConsoleController(console);
		consoleController.start();
	}
}
