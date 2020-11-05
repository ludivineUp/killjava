package fr.library.gui;

import javax.swing.JInternalFrame;

import fr.library.controller.IController;

public class MyJInternalFrame extends JInternalFrame {
	
	private IController controller;
	
	public MyJInternalFrame(IController controller){
		super();
		this.controller = controller;
	}



	public IController getController() {
		return controller;
	}
}
