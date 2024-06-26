package fr.lubac.surfouAPI.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

@Entity
public class ActivityDescription {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Size (min =3, max = 30)
	private String name;
	@Size (min =3, max = 200)
	private String description;
	
	private String urlPhoto;
	
	@OneToMany(targetEntity = NauticalActivity.class, mappedBy = "activityDescription")
	private Set<NauticalActivity> listActivities;
	
	
	
	
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
