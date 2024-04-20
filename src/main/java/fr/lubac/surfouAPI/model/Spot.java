package fr.lubac.surfouAPI.model;

import java.util.Set;

import org.locationtech.jts.geom.Point;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotNull;

@Entity
public class Spot {
	
	@Id  @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String name;
	
	private String city;
	private Point geom;
	
	@OneToMany(targetEntity = NauticalActivity.class, mappedBy = "spot")
	private Set<NauticalActivity> nauticalActivities;
	
	private String imageUrl;
	private String comment;
	private boolean official;
	
	@ManyToOne @JoinColumn(name="creator_user_id", nullable = false)
	private User creatorUser;
	
	@ManyToMany (mappedBy = "bookmarkedSpots")
	private Set<User> bookmarkingUser; 
	
	@ManyToOne
	@JoinColumn(name ="type_id", nullable = false)
	private SpotType type;
	
	
	
//	===================
//	GETTERS AND SETTERS
//	===================
	
	public Set<NauticalActivity> getNauticalActivities() {
		return nauticalActivities;
	}

	public void setNauticalActivities(Set<NauticalActivity> nauticalActivities) {
		this.nauticalActivities = nauticalActivities;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Point getGeom() {
		return geom;
	}
	public void setGeom(Point geom) {
		this.geom = geom;
	}
	public String getImageUrl() {
		return imageUrl;
	}
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Boolean getOfficial() {
		return official;
	}
	public void setOfficial(Boolean official) {
		this.official = official;
	}
	public User getCreatorUser() {
		return creatorUser;
	}
	public void setCreatorUser(User creatorUser) {
		this.creatorUser = creatorUser;
	}
	public Set<User> getBookmarkingUser() {
		return bookmarkingUser;
	}
	public void setBookmarkingUser(Set<User> bookmarkingUser) {
		this.bookmarkingUser = bookmarkingUser;
	}
	public SpotType getType() {
		return type;
	}
	public void setType(SpotType type) {
		this.type = type;
	}
	
	

	
	

}
