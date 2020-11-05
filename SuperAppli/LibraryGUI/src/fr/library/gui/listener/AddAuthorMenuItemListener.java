package fr.library.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.library.controller.Controller;

public class AddAuthorMenuItemListener implements ActionListener {
	
	private Controller controller;
	
	public AddAuthorMenuItemListener(Controller controller){
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.displayAddAuthorFrame();

	}

}
