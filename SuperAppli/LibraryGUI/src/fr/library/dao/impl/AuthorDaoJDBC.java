package fr.library.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.library.beans.Author;
import fr.library.dao.AuthorDao;

public class AuthorDaoJDBC extends JdbcDao implements AuthorDao{

	public AuthorDaoJDBC() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Author author) {
		PreparedStatement statement;
		try {
			statement = getConnection().prepareStatement(
					"INSERT INTO authors(firstname,lastname,pseudo) VALUES(?,?,?)");
			statement.setString(1, author.getFirstname());
			statement.setString(2, author.getLastname());
			statement.setString(3, author.getPseudo());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Author> findAll() {
		List<Author> authors = new ArrayList<Author>();
		try {
			PreparedStatement statement = getConnection().prepareStatement(
					"SELECT * FROM authors"
			);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				authors.add(transformResult(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return authors;
	}

	@Override
	public Author findById(int id) {
		Author author = new Author();
		PreparedStatement statement;
		try {
			statement = getConnection().prepareStatement(
					"SELECT * FROM authors WHERE id = ?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				author = transformResult(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return author;
	}

	@Override
	public Author findByName(String name) {
		Author author = new Author();
		PreparedStatement statement;
		try {
			statement = getConnection().prepareStatement(
					"SELECT * FROM authors WHERE lastname = ?");
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				author = transformResult(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return author;
	}

	@Override
	public void update(Author author) {
		try {
			PreparedStatement statement = getConnection().prepareStatement("UPDATE authors SET firstname = ?, lastname = ?, pseudo = ? WHERE id = ?");
			statement.setString(1, author.getFirstname());
			statement.setString(2, author.getLastname());
			statement.setString(3, author.getPseudo());
			statement.setInt(4, author.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	private Author transformResult(ResultSet resultSet) throws SQLException{
		Author author = new Author();
		author.setId(resultSet.getInt("id"));
		author.setFirstname(resultSet.getString("firstname"));
		author.setLastname(resultSet.getString("lastname"));
		author.setPseudo(resultSet.getString("pseudo"));
		return author;
	}

}
