package fr.library.gui.panel;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import fr.library.controller.IController;
import fr.library.gui.MyJInternalFrame;
import fr.library.gui.listener.AddListener;
import fr.library.gui.listener.CancelListener;

public class ConfirmationPanel extends JPanel {

	private IController controller;
	private int codeAppel; //ce code dit sur quelle fenêtre nous sommes
	/*
	 * 1. ajouter un autheur
	 * 2. ajouter un livre
	 */
	
	public ConfirmationPanel(IController controller, int codeAppel, MyJInternalFrame parent) {
		this.controller = controller;
		this.codeAppel = codeAppel;
		setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button = new JButton("Add");
		button.addActionListener(new AddListener(parent,codeAppel));
		add(button);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new CancelListener(parent));
		add(btnCancel);
	}

}
