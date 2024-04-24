package fr.lubac.surfouAPI.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lubac.surfouAPI.model.WeatherCondition;
import fr.lubac.surfouAPI.repository.WeatherConditionRepository;

@Service
public class WeatherConditionService {
	@Autowired
	private WeatherConditionRepository weatherConditionRepository;

	public WeatherCondition saveWeatherCondition(WeatherCondition weatherCondition) {
		WeatherCondition savedWeatherCondition = weatherConditionRepository.save(weatherCondition);
		return savedWeatherCondition;
	}
	
	public Iterable<WeatherCondition> getWeatherConditions () {
		return weatherConditionRepository.findAll();
	}
	
	public Iterable<WeatherCondition> getWeatherConditionsAccordingWindForce (int windForce) {
		return weatherConditionRepository.findByWindForce(windForce);
	}
	
	public List<WeatherCondition> getWeatherConditionsAccordingWindForceAndDirection (int windForce, int windDirection) {
		List<WeatherCondition> weatherConditionsFilteredByWindForceAndDirection = new ArrayList<WeatherCondition>(); 
		// 1 - first retrieve Weather conditions by wind force : 
		Iterable<WeatherCondition> weatherConditionsFilteredByWindForce = getWeatherConditionsAccordingWindForce(windForce);
		//2 - Filter this Iterable by wind direction compatibility :
		for (WeatherCondition wc : weatherConditionsFilteredByWindForce) {
			if (isWindDirectionCompatible(windDirection, wc.getMinWindDirection(), wc.getMaxWindDirection())){
				weatherConditionsFilteredByWindForceAndDirection.add(wc);
			}
		}
		return weatherConditionsFilteredByWindForceAndDirection;
	}
	
	
	/**
	 * 
	 */
	private boolean isWindDirectionCompatible (int testedWindDirection, int minWindDirection, int maxWindDirection ) {
		boolean compatible = false;
		// First case : minWindDirection > maxWindDirection (interval covering the north 0°&360°)
		if (minWindDirection >= maxWindDirection) {
			if ((testedWindDirection >= minWindDirection && testedWindDirection <= 360) || (testedWindDirection >= 0 && testedWindDirection <= maxWindDirection)) {
				compatible = true;
			}
		// Second case :minWindDirection < maxWindDirection (interval of wind direction not covering the north (0/360°))
		if (minWindDirection < maxWindDirection) {
			if (testedWindDirection >= minWindDirection && testedWindDirection <= maxWindDirection) {
				compatible=true;
			}
		}
		}
	
		return compatible;
	}
}
