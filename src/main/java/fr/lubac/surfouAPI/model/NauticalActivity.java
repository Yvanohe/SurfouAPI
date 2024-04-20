package fr.lubac.surfouAPI.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;

@Entity
public class NauticalActivity {
	@EmbeddedId
	private NauticalActivityID id;
	
	@ManyToOne (cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@MapsId("spotID")
	@JoinColumn(name="spot_id")
	private Spot spot;
	
	@ManyToOne (cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@MapsId("activityDescriptionID")
	@JoinColumn(name="activity_id")
	private ActivityDescription activityDescription;
	
	@ManyToOne (cascade = CascadeType.ALL)
	@MapsId("weatherConditionID")
	@JoinColumn(name="weather_conditions_id")
	private WeatherCondition weatherCondition;
	
	private String name;
	private String description;
	private boolean official;
	
	
	
	
//	===================
//	GETTERS AND SETTERS
//	===================
	
	
	public Spot getSpot() {
		return spot;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSpot(Spot spot) {
		this.spot = spot;
	}
	public ActivityDescription getActivityDescription() {
		return activityDescription;
	}
	public void setActivityDescription(ActivityDescription activityDescription) {
		this.activityDescription = activityDescription;
	}
	public WeatherCondition getWeatherCondition() {
		return weatherCondition;
	}
	public void setWeatherCondition(WeatherCondition weatherCondition) {
		this.weatherCondition = weatherCondition;
	}
	public Boolean getOfficial() {
		return official;
	}
	public void setOfficial(Boolean official) {
		this.official = official;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	
	
	
	
}
