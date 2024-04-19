package fr.lubac.surfouAPI.model;

public class WeatherCondition {
	private int id;
	private int minWindDirection;
	private int mawWindDirection;
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
		return mawWindDirection;
	}
	public void setMawWindDirection(int mawWindDirection) {
		this.mawWindDirection = mawWindDirection;
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
