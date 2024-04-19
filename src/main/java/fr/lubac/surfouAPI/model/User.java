package fr.lubac.surfouAPI.model;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity
public class User {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String username;
	
	@Email
	private String email;
	
	@NotNull
	private String paswword;
	
	@OneToMany (targetEntity = Spot.class, mappedBy = "creatorUser")
	private List<Spot> spotCreated;
	
	@ManyToMany
	@JoinTable( name = "Users_Spots_bookmarked",
				joinColumns = @JoinColumn(name="idUser"),
				inverseJoinColumns = @JoinColumn(name = "idSpot"))
	private Set<Spot> bookmarkedSpots;

	
	
//	===================
//	GETTERS AND SETTERS
//	===================
	
	public String getUsername() {
		return username;
	}
	public List<Spot> getSpotCreated() {
		return spotCreated;
	}
	public void setSpotCreated(List<Spot> spotCreated) {
		this.spotCreated = spotCreated;
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
