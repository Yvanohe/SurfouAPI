package fr.lubac.surfouAPI.model;

public class ActivityDescription {

	private int id;
	private String name;
	private String description;
	private String urlPhoto;
	
	
	
	
	
//	===================
//	GETTERS AND SETTERS
//	===================
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUrlPhoto() {
		return urlPhoto;
	}
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}
	public int getId() {
		return id;
	}
	
}
