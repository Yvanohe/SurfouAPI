package fr.lubac.surfouAPI.model;

import java.util.List;

import org.locationtech.jts.geom.Point;

public class Spot {
	
	private int id;
	private int name;
	private int city;
	private Point geom;
	private List<NauticalActivity> nauticalActivities;
	private String imageUrl;
	private String comment;
	private Boolean official;
	private User creatorUser;
	private List<User> bookmarkingUser;
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

	public int getName() {
		return name;
	}
	public void setName(int name) {
		this.name = name;
	}
	public int getCity() {
		return city;
	}
	public void setCity(int city) {
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
	public List<User> getBookmarkingUser() {
		return bookmarkingUser;
	}
	public void setBookmarkingUser(List<User> bookmarkingUser) {
		this.bookmarkingUser = bookmarkingUser;
	}
	public SpotType getType() {
		return type;
	}
	public void setType(SpotType type) {
		this.type = type;
	}
	
	

	
	

}
