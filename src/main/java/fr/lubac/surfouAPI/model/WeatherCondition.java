package fr.lubac.surfouAPI.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class WeatherCondition {
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private int id;
	
	/*
	 * Directions in degree (°%360)
	 * Force in knots (kn)
	 * Heights in meters (m)
	 * Periods in seconds (s)
	 */
	
	private Integer minWindDirection;
	private Integer  maxWindDirection;
	private Integer  minWindForce;
	private Integer  maxWindForce;
	private Float minTideHeight;
	private Float maxTideHeight;
	private Integer minWaveDirection;
	private Integer maxWaveDirection;
	private Float minWaveHeight;
	private Float maxWaveHeight;
	private Integer minWavePeriod;
	private Integer maxWavePeriod;

	@OneToMany(targetEntity = NauticalActivity.class, mappedBy = "weatherCondition")
	@JsonBackReference
	private Set<NauticalActivity> nauticalActivities;
	
//	===================
//	GETTERS AND SETTERS
//	===================
	
	
	public Integer getMinWindDirection() {
		return minWindDirection;
	}
	public Set<NauticalActivity> getNauticalActivities() {
		return nauticalActivities;
	}
	public void setNauticalActivities(Set<NauticalActivity> nauticalActivities) {
		this.nauticalActivities = nauticalActivities;
	}
	public void setMinWindDirection(int minWindDirection) {
		this.minWindDirection = minWindDirection;
	}
	public Integer getMaxWindDirection() {
		return maxWindDirection;
	}
	public void setMaxWindDirection(int mawWindDirection) {
		this.maxWindDirection = mawWindDirection;
	}
	public Integer getMinWindForce() {
		return minWindForce;
	}
	public void setMinWindForce(int minWindForce) {
		this.minWindForce = minWindForce;
	}
	public Integer getMaxWindForce() {
		return maxWindForce;
	}
	public void setMaxWindForce(int maxWindForce) {
		this.maxWindForce = maxWindForce;
	}
	public Float getMinTideHeight() {
		return minTideHeight;
	}
	public void setMinTideHeight(float minTideHeight) {
		this.minTideHeight = minTideHeight;
	}
	public Float getMaxTideHeight() {
		return maxTideHeight;
	}
	public void setMaxTideHeight(float maxTideHeight) {
		this.maxTideHeight = maxTideHeight;
	}
	public Integer getMinWaveDirection() {
		return minWaveDirection;
	}
	public void setMinWaveDirection(int minWaveDirection) {
		this.minWaveDirection = minWaveDirection;
	}
	public Integer getMaxWaveDirection() {
		return maxWaveDirection;
	}
	public void setMaxWaveDirection(int maxWaveDirection) {
		this.maxWaveDirection = maxWaveDirection;
	}
	public Float getMinWaveHeight() {
		return minWaveHeight;
	}
	public void setMinWaveHeight(float minWaveHeight) {
		this.minWaveHeight = minWaveHeight;
	}
	public Float getMaxWaveHeight() {
		return maxWaveHeight;
	}
	public void setMaxWaveHeight(float maxWaveHeight) {
		this.maxWaveHeight = maxWaveHeight;
	}
	public Integer getMinWavePeriod() {
		return minWavePeriod;
	}
	public void setMinWavePeriod(int minWavePeriod) {
		this.minWavePeriod = minWavePeriod;
	}
	public Integer getMaxWavePeriod() {
		return maxWavePeriod;
	}
	public void setMaxWavePeriod(int maxWavePeriod) {
		this.maxWavePeriod = maxWavePeriod;
	}
	public Integer getId() {
		return id;
	}
	
	
}
