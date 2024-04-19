package fr.lubac.surfouAPI.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class SpotType {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	private String name;
	private String description;
	
	@OneToMany (targetEntity = Spot.class, mappedBy = "type")
	private List<Spot> spots;
	
	
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
	public int getId() {
		return id;
	}
	
	

}
