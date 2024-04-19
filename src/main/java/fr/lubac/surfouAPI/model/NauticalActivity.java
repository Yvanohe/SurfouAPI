package fr.lubac.surfouAPI.model;

public class NauticalActivity {
	private Spot spot;
	private ActivityDescription activityDescription;
	private WeatherCondition weatherCondition;
	
	private String name;
	private String description;
	private Boolean official;
	
	
	
	
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
