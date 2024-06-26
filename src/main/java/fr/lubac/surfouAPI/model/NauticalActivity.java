package fr.lubac.surfouAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class NauticalActivity {
	@EmbeddedId
	private NauticalActivityID id = new NauticalActivityID();
	
	@Size (min =3, max = 30)
	private String name;
	
	@Size (min =3, max = 200)
	private String description;
	
	@NotNull
	private boolean official;
	
	@ManyToOne (cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@MapsId("spotID")
	@JoinColumn(name="spot_id")
	@JsonIgnoreProperties("nauticalActivities")
	private Spot spot;
	
	@ManyToOne (cascade = {CascadeType.MERGE, CascadeType.PERSIST})
	@MapsId("activityDescriptionID")
	@JoinColumn(name="activity_id")
	@JsonIncludeProperties({"id","name"})
	private ActivityDescription activityDescription;
	
	@ManyToOne (cascade = {CascadeType.MERGE, CascadeType.PERSIST} )
	@MapsId("weatherConditionID")
	@JoinColumn(name="weather_conditions_id")
	private WeatherCondition weatherCondition;
	
	
	
	
	
//	===================
//	GETTERS AND SETTERS
//	===================
	
	
	public Spot getSpot() {
		return spot;
	}
	public NauticalActivityID getId() {
		return id;
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
