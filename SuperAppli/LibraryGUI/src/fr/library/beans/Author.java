package fr.library.beans;

import java.io.Serializable;

import com.sun.org.apache.xpath.internal.compiler.PsuedoNames;

public class Author implements Serializable{
	
	private static final long serialVersionUID = 800156719128851600L;
	
	private int id;
	private String firstname;
	private String lastname;
	private String pseudo;
	
	public Author(){
		pseudo = "";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Override
	public String toString() {
		String str = "";
		if(firstname != null){
			str += firstname+" ";
		}
		if(lastname != null){
			str += lastname;
		}
		if(pseudo != null && pseudo.compareTo("") != 0){
			str += " "+pseudo;
		}
		return str;
	}

	
}
