package fr.library.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.library.beans.Book;
import fr.library.beans.Editor;
import fr.library.dao.BookDao;
import fr.library.dao.DaoFactory;

public class BookDaoJdbc extends JdbcDao implements BookDao {

	public BookDaoJdbc() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Book book) {
		PreparedStatement statement;
		try {
			statement = getConnection().prepareStatement(
					"INSERT INTO books(title,editors,authors,parution) VALUES(?,?,?,?)");
			statement.setString(1, book.getTitle());
			statement.setInt(2, book.getEditor().getId());
			statement.setInt(3, book.getAuthor().getId());
			if(book.getParution() == null){
				statement.setDate(4, null);
			}else{
				Date datesql = new Date(book.getParution().getTime());
				statement.setDate(4, datesql);
			}
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Book> findAll() {
		List<Book> books = new ArrayList<Book>();
		try {
			PreparedStatement statement = getConnection().prepareStatement(
					"SELECT * FROM books"
			);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				books.add(transformResult(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return books;
	}

	@Override
	public Book findById(int id) {
		Book book = new Book();
		PreparedStatement statement;
		try {
			statement = getConnection().prepareStatement(
					"SELECT * FROM books WHERE id = ?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				book = transformResult(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public Book findByName(String name) {
		Book book = new Book();
		PreparedStatement statement;
		try {
			statement = getConnection().prepareStatement(
					"SELECT * FROM books WHERE title = ?");
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				book = transformResult(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	@Override
	public void update(Book book) {
		try {
			PreparedStatement statement = getConnection().prepareStatement("UPDATE books SET title = ?, editors = ?, authors = ?, parution = ? WHERE id = ?");
			statement.setString(1, book.getTitle());
			statement.setInt(2, book.getEditor().getId());
			statement.setInt(3, book.getAuthor().getId());
			if(book.getParution() == null){
				statement.setDate(4, null);
			}else{
				Date datesql = new Date(book.getParution().getTime());
				statement.setDate(4, datesql);
			}
			statement.setInt(5, book.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	private Book transformResult(ResultSet resultSet) throws SQLException{
		Book book = new Book();
		book.setId(resultSet.getInt("id"));
		book.setParution((resultSet.getDate("parution")));
		book.setTitle(resultSet.getString("title"));
		
		int editorID = resultSet.getInt("editors");
		Editor editor = DaoFactory.getEditorDao().findById(editorID);
		book.setEditor(editor);
		
		int authorId = resultSet.getInt("authors");
		book.setAuthor(DaoFactory.getAuthorDao().findById(authorId));

		return book;
	}
}
