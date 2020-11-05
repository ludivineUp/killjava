package fr.library.launcher;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import fr.library.beans.Author;
import fr.library.beans.Book;
import fr.library.beans.Editor;
import fr.library.controller.Controller;
import fr.library.dao.DaoFactory;

public class Launcher {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Author> authors;
		try {
			System.out.println("Liste des auteurs : ");
			authors = DaoFactory.getAuthorDao().findAll();
			for (Author author : authors) {
				System.out.println(author);
			}
			System.out.println("*** *** ***\n");

			System.out.println("Liste des editeurs : ");
			List<Editor> editors = DaoFactory.getEditorDao().findAll();
			for (Editor editor : editors) {
				System.out.println(editor);
			}
			System.out.println("*** *** ***\n");

			System.out.println("Liste des livres : ");
			List<Book> books = DaoFactory.getBookDao().findAll();
			for (Book book : books) {
				System.out.println(book);
			}
			System.out.println("*** *** ***\n");

			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						try {
							for (LookAndFeelInfo info : UIManager
									.getInstalledLookAndFeels()) {
								if ("Nimbus".equals(info.getName())) {
									UIManager.setLookAndFeel(info
											.getClassName());
									break;
								}
							}
						} catch (UnsupportedLookAndFeelException e) {
							// handle exception
						} catch (ClassNotFoundException e) {
							// handle exception
						} catch (InstantiationException e) {
							// handle exception
						} catch (IllegalAccessException e) {
							// handle exception
						}
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			
			Controller controller = new Controller();
			controller.displayMaiFrame();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
