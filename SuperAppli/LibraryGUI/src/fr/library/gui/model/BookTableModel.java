package fr.library.gui.model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import fr.library.beans.Book;
import fr.library.dao.DaoFactory;

public class BookTableModel extends AbstractTableModel {

	private List<Book> books;

	public BookTableModel() {
		books = new ArrayList<Book>();
		try {
			books = DaoFactory.getBookDao().findAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return books.size();
	}

	@Override
	public String getColumnName(int col) {
		if (col == 0) {
			return "Titre";
		} else if (col == 1) {
			return "Auteur";
		} else if (col == 2) {
			return "Editeur";
		} else {
			return "Parution";
		}
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		if(col == 1 ||(col == 2))
			return false;
		return true;
	}

	@Override
	public void setValueAt(Object arg0, int row, int col) {
		// TODO Auto-generated method stub
		if (col == 0) {
			books.get(row).setTitle((String) arg0);			
		} else if (col == 3) {
			books.get(row).setParution(new Date((String) arg0));
		}
	}

	@Override
	public Object getValueAt(int row, int col) {
		// TODO Auto-generated method stub
		if (col == 0) {
			return books.get(row).getTitle();
		} else if (col == 1) {
			return books.get(row).getAuthor().getLastname();
		} else if (col == 2) {
			return books.get(row).getEditor().getName();
		} else if (col == 3) {
			return books.get(row).getParution().toLocaleString();
		}
		return null;
	}

}
