package fr.library.gui.listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JInternalFrame;

import fr.library.beans.Author;
import fr.library.beans.Book;
import fr.library.beans.Editor;
import fr.library.controller.AuthorController;
import fr.library.controller.BookController;
import fr.library.gui.AddAuthorFrame;
import fr.library.gui.AddBookFrame;
import fr.library.gui.MyJInternalFrame;

public class AddListener implements ActionListener {
	
	private int codeAppel;
	private MyJInternalFrame parent;
	
	public AddListener(MyJInternalFrame parent, int codeAppel) {
		super();
		this.codeAppel = codeAppel;
		this.parent = parent;
	}




	@Override
	public void actionPerformed(ActionEvent arg0) {
		if(codeAppel == 1){
			//on s'occupe d'ajouter un auteur
			if(parent.getController() instanceof AuthorController){
				((AuthorController) parent.getController()).setAuthor(
						((AddAuthorFrame)parent).getAuhtorPanel().getFirstname().getText(), 
						((AddAuthorFrame)parent).getAuhtorPanel().getLastname().getText(),
						((AddAuthorFrame)parent).getAuhtorPanel().getPseudo().getText());
			}
			try {
				parent.getController().okButton();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			parent.dispose();
		}else if(codeAppel == 2){
			if(parent.getController() instanceof BookController){
				Book book = new Book();
				book.setTitle(((AddBookFrame)parent).getBookPanel().getTitle().getText());
				book.setAuthor((Author)((AddBookFrame)parent).getBookPanel().getAuthor().getSelectedItem());
				book.setEditor((Editor)((AddBookFrame)parent).getBookPanel().getEditor().getSelectedItem());
				//je triche : je mets la date d'aujourd'hui
				book.setParution(new Date());
				((BookController)parent.getController()).setBook(book);
			}
			try {
				parent.getController().okButton();
				parent.dispose();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
