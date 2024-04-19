package fr.lubac.surfouAPI.model;

public class User {
	private int id;
	private String username;
	private String email;
	private String paswword;

	
	
//	===================
//	GETTERS AND SETTERS
//	===================
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPaswword() {
		return paswword;
	}
	public void setPaswword(String paswword) {
		this.paswword = paswword;
	}
	public int getId() {
		return id;
	}

}
