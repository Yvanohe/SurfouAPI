package fr.lubac.surfouAPI.model;

import java.util.Set;

import org.hibernate.validator.constraints.Range;

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
	@Range(min=0, max=360)
	private Integer minWindDirection;
	
	@Range(min=0, max=360)
	private Integer  maxWindDirection;
	
	@Range(min=0, max=100)	
	private Integer  minWindForce;
	
	@Range(min=0, max=100)
	private Integer  maxWindForce;
	
	@Range(min=0, max=18)
	private Float minTideHeight;
	@Range(min=0, max=18)
	private Float maxTideHeight;
	
	@Range(min=0, max=360)
	private Integer minWaveDirection;
	
	@Range(min=0, max=360)
	private Integer maxWaveDirection;
	
	@Range(min=0, max=50)
	private Float minWaveHeight;
	@Range(min=0, max=50)
	private Float maxWaveHeight;
	
	@Range(min=0, max=30)
	private Integer minWavePeriod;
	
	@Range(min=0, max=30)
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
