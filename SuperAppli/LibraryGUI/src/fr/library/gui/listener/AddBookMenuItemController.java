package fr.library.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import fr.library.controller.Controller;

public class AddBookMenuItemController implements ActionListener {
private Controller controller;
	
	public AddBookMenuItemController(Controller controller){
		this.controller = controller;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			controller.displayAddBookFrame();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
