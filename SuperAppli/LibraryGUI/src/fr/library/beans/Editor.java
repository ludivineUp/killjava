package fr.library.beans;

import java.io.Serializable;

public class Editor implements Serializable {
	
	static final long serialVersionUID = -3985731296670198185L;
	
	private int id;
	private String name;
	private String adress;
	
	public Editor() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	@Override
	public String toString() {
		return "Editor [id=" + id + ", name=" + name + ", adress=" + adress
				+ "]";
	}
	
	

}
