package fr.library.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;

import fr.library.controller.IController;
import fr.library.gui.panel.AuhtorPanel;
import fr.library.gui.panel.ConfirmationPanel;

public class AddAuthorFrame extends MyJInternalFrame {

	private AuhtorPanel auhtorPanel;
	private ConfirmationPanel confirmationPanel;
	
	public AddAuthorFrame(IController controller) {
		super(controller);
		setBounds(100, 100, 400, 150);
		setMinimumSize(new Dimension(200, 150));
		setTitle("Add author");
		setVisible(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel mainPanel = new JPanel(new BorderLayout());
		auhtorPanel = new AuhtorPanel();
		confirmationPanel = new ConfirmationPanel(controller,1,this);
		mainPanel.add(auhtorPanel,BorderLayout.CENTER);
		mainPanel.add(confirmationPanel, BorderLayout.SOUTH);
		getContentPane().add(mainPanel);
	}

	public AuhtorPanel getAuhtorPanel() {
		return auhtorPanel;
	}

}
