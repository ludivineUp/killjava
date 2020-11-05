package fr.library.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.library.beans.Editor;
import fr.library.dao.EditorDao;

public class EditorDaoJdbc extends JdbcDao implements EditorDao {

	public EditorDaoJdbc() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(Editor editor) {
		PreparedStatement statement;
		try {
			statement = getConnection().prepareStatement(
					"INSERT INTO editors(name,adress) VALUES(?,?)");
			statement.setString(1, editor.getName());
			statement.setString(2, editor.getAdress());
			statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Editor> findAll() {
		List<Editor> editors = new ArrayList<Editor>();
		try {
			PreparedStatement statement = getConnection().prepareStatement(
					"SELECT * FROM editors"
			);
			
			ResultSet resultSet = statement.executeQuery();
			while(resultSet.next()) {
				editors.add(transformResult(resultSet));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return editors;
	}

	@Override
	public Editor findById(int id) {
		Editor editor = new Editor();
		PreparedStatement statement;
		try {
			statement = getConnection().prepareStatement(
					"SELECT * FROM editors WHERE id = ?");
			statement.setInt(1, id);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				editor = transformResult(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return editor;
	}

	@Override
	public Editor findByName(String name) {
		Editor editor = new Editor();
		PreparedStatement statement;
		try {
			statement = getConnection().prepareStatement(
					"SELECT * FROM editors WHERE name = ?");
			statement.setString(1, name);
			ResultSet resultSet = statement.executeQuery();
			if(resultSet.next()) {
				editor = transformResult(resultSet);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return editor;
	}

	@Override
	public void update(Editor editor) {
		try {
			PreparedStatement statement = getConnection().prepareStatement("UPDATE editors SET name = ?, adress = ?  WHERE id = ?");
			statement.setString(1, editor.getName());
			statement.setString(2, editor.getAdress());
			statement.setInt(3, editor.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	private Editor transformResult(ResultSet resultSet) throws SQLException{
		Editor editor = new Editor();
		editor.setId(resultSet.getInt("id"));
		editor.setName(resultSet.getString("name"));
		editor.setAdress(resultSet.getString("adress"));
		return editor;
	}

}






