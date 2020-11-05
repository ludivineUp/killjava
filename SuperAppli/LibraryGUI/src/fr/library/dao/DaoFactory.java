package fr.library.dao;

import java.sql.SQLException;

import fr.library.dao.impl.AuthorDaoJDBC;
import fr.library.dao.impl.BookDaoJdbc;
import fr.library.dao.impl.EditorDaoJdbc;

public class DaoFactory {
	
	private static BookDao bookDao;
	private static EditorDao editorDao;
	private static AuthorDao authorDao;
	
	private DaoFactory(){
		throw new IllegalStateException();
	}
	
	
	
	public static BookDao getBookDao() throws SQLException{
		if(bookDao == null)
			return new BookDaoJdbc();
		return bookDao;
	}



	public static EditorDao getEditorDao() throws SQLException{
		if(editorDao == null)
			editorDao = new EditorDaoJdbc();
		return editorDao;
	}



	public static AuthorDao getAuthorDao() throws SQLException{
		if(authorDao == null)
			authorDao = new AuthorDaoJDBC();
		return authorDao;
	}



}