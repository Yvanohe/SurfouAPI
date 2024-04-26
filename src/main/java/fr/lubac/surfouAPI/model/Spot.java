package fr.lubac.surfouAPI.model;

import java.util.List;
import java.util.Set;

import org.locationtech.jts.geom.Point;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

//Theses ones doesn't work with geojson
//import com.bedatadriven.jackson.datatype.jts.serialization.GeometryDeserializer;
//import com.bedatadriven.jackson.datatype.jts.serialization.GeometrySerializer;
import org.n52.jackson.datatype.jts.GeometrySerializer;
import org.n52.jackson.datatype.jts.GeometryDeserializer;

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
	
	@JsonSerialize(using = GeometrySerializer.class)
	@JsonDeserialize(contentUsing = GeometryDeserializer.class)
	private Point geom;
	
	@OneToMany(targetEntity = NauticalActivity.class, mappedBy = "spot")
	@JsonIncludeProperties("activityDescription")
	//@JsonBackReference
	private List<NauticalActivity> nauticalActivities;
	
	private String imageUrl;
	private String comment;
	private boolean official;
	
	@ManyToOne @JoinColumn(name="creator_user_id", nullable = false)
	//@JsonManagedReference
	@JsonIncludeProperties({"id","username"}) // exclude "spotcreated" to avoid infinite recursion
	private User creatorUser;
	
	@ManyToMany (mappedBy = "bookmarkedSpots")
	@JsonIncludeProperties("id")
	private Set<User> bookmarkingUsers; 
	
	@ManyToOne
	@JoinColumn(name ="type_id")
	@JsonIgnoreProperties("description")
	private SpotType type;
	
	

//	===================
//	GETTERS AND SETTERS
//	===================
	
	

	public List<NauticalActivity> getNauticalActivities() {
		return nauticalActivities;
	}

	public void setNauticalActivities(List<NauticalActivity> nauticalActivities) {
		this.nauticalActivities = nauticalActivities;
	}

	public int getId() {
		return id;
	}
	
	public void deleteId() {
		this.id=0;
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
	public Set<User> getBookmarkingUsers() {
		return bookmarkingUsers;
	}
	public void setBookmarkingUsers(Set<User> bookmarkingUsers) {
		this.bookmarkingUsers = bookmarkingUsers;
	}
	public SpotType getType() {
		return type;
	}
	public void setType(SpotType type) {
		this.type = type;
	}
		
		

}
