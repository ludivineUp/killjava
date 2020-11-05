package fr.library.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import fr.library.controller.IController;
import fr.library.gui.panel.AuhtorPanel;
import fr.library.gui.panel.BookPanel;
import fr.library.gui.panel.ConfirmationPanel;

public class AddBookFrame extends MyJInternalFrame {
	
	private BookPanel bookPanel;
	private ConfirmationPanel confirmationPanel;
	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public AddBookFrame(IController controller) throws SQLException {
		super(controller);
		setVisible(true);
		setBounds(100, 100, 400, 200);
		setMinimumSize(new Dimension(200, 200));
		setTitle("Add author");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setLayout(new BorderLayout());
		JPanel mainPanel = new JPanel(new BorderLayout());
		bookPanel = new BookPanel();
		mainPanel.add(bookPanel,BorderLayout.CENTER);
		confirmationPanel = new ConfirmationPanel(controller, 2, this);
		mainPanel.add(confirmationPanel, BorderLayout.SOUTH);
		getContentPane().add(mainPanel);
	}
	public BookPanel getBookPanel() {
		return bookPanel;
	}
	public ConfirmationPanel getConfirmationPanel() {
		return confirmationPanel;
	}
	
}
