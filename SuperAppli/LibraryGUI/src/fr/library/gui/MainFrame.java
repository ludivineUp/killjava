package fr.library.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.EmptyBorder;

import fr.library.controller.Controller;
import fr.library.gui.listener.AddAuthorMenuItemListener;
import fr.library.gui.listener.AddBookMenuItemController;
import fr.library.gui.listener.ListBookMenuItemListener;
import fr.library.gui.listener.QuitListener;

public class MainFrame extends JFrame {

	private JDesktopPane desktopPane;
	private Controller controller;

	/**
	 * Create the frame.
	 */
	public MainFrame(Controller controller) {
		this.controller = controller;
		setTitle("Ma libraie");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		desktopPane = new JDesktopPane();
		setContentPane(desktopPane);
		JMenuBar menuBar = new JMenuBar();
		
		JMenu file = new JMenu("Fichier");
		
		JMenuItem addBook = new JMenuItem("Ajouter un livre");
		addBook.addActionListener(new AddBookMenuItemController(controller));
		file.add(addBook);
		JMenuItem addAuthor = new JMenuItem("Ajouter un auteur");
		addAuthor.addActionListener(new AddAuthorMenuItemListener(controller));
		file.add(addAuthor);
		JMenuItem listBook = new JMenuItem("Liste des livres");
		listBook.addActionListener(new ListBookMenuItemListener(controller));
		file.add(listBook);
		JMenuItem listAuthor = new JMenuItem("Liste des auteurs");
		file.add(listAuthor);
		
		menuBar.add(file);
		
		JMenuItem quit = new JMenuItem("quit");
		quit.addActionListener(new QuitListener(this));
		JMenu actions = new JMenu("Actions");
		actions.add(quit);
		menuBar.add(actions);
		setJMenuBar(menuBar);
	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}

	public Controller getController() {
		return controller;
	}
}
