package fr.lubac.surfouAPI.model;

import java.util.Date;
import java.util.List;
import java.util.Set;


import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import fr.lubac.surfouAPI.security.Role;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

@Entity @Table(name="user_account")
public class User {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String username;
	
	@Email
	private String email;
	
	@NotNull
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	private Date accountCreationDate = new Date(); 
	
	@OneToMany (targetEntity = Spot.class, mappedBy = "creatorUser")
	@JsonIncludeProperties({"id","name"})	
	private List<Spot> spotCreated;
	
	@ManyToMany
	@JoinTable( name = "Users_Spots_bookmarked",
				joinColumns = @JoinColumn(name="id_user"),
				inverseJoinColumns = @JoinColumn(name = "id_spot"))
	@JsonIncludeProperties({"id","name"})	
	private Set<Spot> bookmarkedSpots;

	@ManyToOne @JoinColumn(name ="role_id", nullable = false)
	private Role role;
	
	
//	===================
//	GETTERS AND SETTERS
//	===================
	
	public String getUsername() {
		return username;
	}

	public Set<Spot> getBookmarkedSpots() {
		return bookmarkedSpots;
	}
	public void setBookmarkedSpots(Set<Spot> bookmarkedSpots) {
		this.bookmarkedSpots = bookmarkedSpots;
	}
	public Date getAccountCreationDate() {
		return accountCreationDate;
	}
	public void setAccountCreationDate(Date accountCreationDate) {
		this.accountCreationDate = accountCreationDate;
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String paswword) {
		this.password = paswword;
	}
	public int getId() {
		return id;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("User : [")
			.append("username = ").append(this.getUsername())
			.append(", email = ").append(this.getEmail())
			.append(", password = ").append(this.password)
			.append(", creation date = ").append(this.getAccountCreationDate())
			.append("]");
		
		return sb.toString();
	}

}
