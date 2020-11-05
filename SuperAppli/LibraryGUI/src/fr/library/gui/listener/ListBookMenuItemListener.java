package fr.library.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fr.library.controller.Controller;

public class ListBookMenuItemListener implements ActionListener {

	private Controller controller;
	
	public ListBookMenuItemListener(Controller controller) {
		super();
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.displayListBookFrame();
	}
}
