package fr.lubac.surfouAPI.model;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class NauticalActivityID implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int spotID;
	private int activityDescriptionID;
	private int weatherConditionID;
	
//	===================
//	GETTERS AND SETTERS
//	===================
	public int getSpotID() {
		return spotID;
	}
	public void setSpotID(int spotID) {
		this.spotID = spotID;
	}
	public int getActivityDescriptionID() {
		return activityDescriptionID;
	}
	public void setActivityDescriptionID(int activityDescriptionID) {
		this.activityDescriptionID = activityDescriptionID;
	}
	public int getWeatherConditionID() {
		return weatherConditionID;
	}
	public void setWeatherConditionID(int weatherConditionID) {
		this.weatherConditionID = weatherConditionID;
	}

	
	
	
}
