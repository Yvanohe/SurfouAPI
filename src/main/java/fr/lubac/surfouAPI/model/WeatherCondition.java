package fr.lubac.surfouAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
	
	private int minWindDirection;
	private int maxWindDirection;
	private int minWindForce;
	private int maxWindForce;
	private float minTideHeight;
	private float maxTideHeight;
	private int minWaveDirection;
	private int maxWaveDirection;
	private float minWaveHeight;
	private float maxWaveHeight;
	private int minWavePeriod;
	private int maxWavePeriod;

	
//	===================
//	GETTERS AND SETTERS
//	===================
	public int getMinWindDirection() {
		return minWindDirection;
	}
	public void setMinWindDirection(int minWindDirection) {
		this.minWindDirection = minWindDirection;
	}
	public int getMawWindDirection() {
		return maxWindDirection;
	}
	public void setMawWindDirection(int mawWindDirection) {
		this.maxWindDirection = mawWindDirection;
	}
	public int getMinWindForce() {
		return minWindForce;
	}
	public void setMinWindForce(int minWindForce) {
		this.minWindForce = minWindForce;
	}
	public int getMaxWindForce() {
		return maxWindForce;
	}
	public void setMaxWindForce(int maxWindForce) {
		this.maxWindForce = maxWindForce;
	}
	public float getMinTideHeight() {
		return minTideHeight;
	}
	public void setMinTideHeight(float minTideHeight) {
		this.minTideHeight = minTideHeight;
	}
	public float getMaxTideHeight() {
		return maxTideHeight;
	}
	public void setMaxTideHeight(float maxTideHeight) {
		this.maxTideHeight = maxTideHeight;
	}
	public int getMinWaveDirection() {
		return minWaveDirection;
	}
	public void setMinWaveDirection(int minWaveDirection) {
		this.minWaveDirection = minWaveDirection;
	}
	public int getMaxWaveDirection() {
		return maxWaveDirection;
	}
	public void setMaxWaveDirection(int maxWaveDirection) {
		this.maxWaveDirection = maxWaveDirection;
	}
	public float getMinWaveHeight() {
		return minWaveHeight;
	}
	public void setMinWaveHeight(float minWaveHeight) {
		this.minWaveHeight = minWaveHeight;
	}
	public float getMaxWaveHeight() {
		return maxWaveHeight;
	}
	public void setMaxWaveHeight(float maxWaveHeight) {
		this.maxWaveHeight = maxWaveHeight;
	}
	public int getMinWavePeriod() {
		return minWavePeriod;
	}
	public void setMinWavePeriod(int minWavePeriod) {
		this.minWavePeriod = minWavePeriod;
	}
	public int getMaxWavePeriod() {
		return maxWavePeriod;
	}
	public void setMaxWavePeriod(int maxWavePeriod) {
		this.maxWavePeriod = maxWavePeriod;
	}
	public int getId() {
		return id;
	}
	
	
}
