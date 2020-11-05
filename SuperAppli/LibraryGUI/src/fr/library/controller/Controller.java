package fr.library.controller;

import java.sql.SQLException;

import fr.library.gui.AddAuthorFrame;
import fr.library.gui.AddBookFrame;
import fr.library.gui.ListBookFrame;
import fr.library.gui.MainFrame;

public class Controller {
	
	private static AuthorController authorController;
	private static BookController bookController;
	
	private MainFrame mainFrame;
	private AddAuthorFrame addAuthorFrame;
	private AddBookFrame addBookFrame;
	private ListBookFrame listBookFrame; 

	
	public void displayMaiFrame(){
		mainFrame = new MainFrame(this);
		mainFrame.setVisible(true);
	}
	
	public void displayAddAuthorFrame(){
		addAuthorFrame = new AddAuthorFrame(getAuthorController());
		System.out.println("on est dans le controlleur");
		mainFrame.getDesktopPane().add(addAuthorFrame);		
	}
	
	public void displayAddBookFrame() throws SQLException{
		addBookFrame = new AddBookFrame(getBookController());
		mainFrame.getDesktopPane().add(addBookFrame);		
	}
	
	public void displayListBookFrame(){
		listBookFrame = new ListBookFrame(getBookController());
		mainFrame.getDesktopPane().add(listBookFrame);	
	}
	
	public static AuthorController getAuthorController(){
		if(authorController == null)
			authorController = new AuthorController();
		return authorController;
	}
	
	public static BookController getBookController(){
		if(bookController == null)
			bookController = new BookController();
		return bookController;
	}

}
