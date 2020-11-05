package fr.library.controller;

import java.sql.SQLException;

import fr.library.beans.Author;
import fr.library.dao.DaoFactory;

public class AuthorController implements IController {

	private Author author;

	@Override
	public void okButton() throws SQLException {
		// on enregistre l'autre dans la base de données
		DaoFactory.getAuthorDao().create(author);
	}

	public void setAuthor(String firstname, String lastname, String pseudo) {
		// on crée l'auteur
		author = new Author();
		if(firstname == null)
			firstname = "";
		if(lastname == null)
			lastname = "";
		if(pseudo == null)
			pseudo = "";
		author.setFirstname(firstname);
		author.setLastname(lastname);
		author.setPseudo(pseudo);
	}

}
