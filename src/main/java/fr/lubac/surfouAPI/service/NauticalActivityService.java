package fr.lubac.surfouAPI.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lubac.surfouAPI.model.NauticalActivity;
import fr.lubac.surfouAPI.model.WeatherCondition;
import fr.lubac.surfouAPI.repository.NauticalActivityRepository;

@Service
public class NauticalActivityService {
	@Autowired
	private NauticalActivityRepository nauticalActivityRepository;
	
	@Autowired
	private WeatherConditionService weatherConditionService;
	
	public NauticalActivity saveNauticalActivity (NauticalActivity nauticalActivity) {
		NauticalActivity savedNauticalActivity = nauticalActivityRepository.save(nauticalActivity);
		return savedNauticalActivity;
	}
	
	public Iterable<NauticalActivity> getNauticalActivities() {
		return nauticalActivityRepository.findAll();
	}
	
	public Iterable<NauticalActivity> getNauticalActivitiesByWindcompatibility(int windForce, int windDirection) {
		//First - Retrieve all Weather conditions compatibles with given wind conditions (force and direction) :
		Iterable<WeatherCondition> compatiblesWeatherCondition= weatherConditionService.getWeatherConditionsAccordingWindForceAndDirection(windForce, windDirection);
		//Then get set of Nautical Activity object extracted form the differents WeatherCondition objects
		Set<NauticalActivity> nauticalActivitiesExtracted = getSetOfNauticalActivitiesFromWeatherConditions(compatiblesWeatherCondition);
		return nauticalActivitiesExtracted;
	}
	
	public Iterable<NauticalActivity> getNauticalActivitiesByWindForcecompatibility (int windForce) {
		// First, retrieve all Weather conditions compatibles with given wind conditions (only force) :
		Iterable<WeatherCondition> compatiblesWeatherCondition= weatherConditionService.getWeatherConditionsAccordingWindForce(windForce);
		// Then get set of Nautical Activity object extracted form the differents WeatherCondition objects
		Set<NauticalActivity> nauticalActivitiesExtracted = getSetOfNauticalActivitiesFromWeatherConditions(compatiblesWeatherCondition);
		return nauticalActivitiesExtracted;
	}
	
	public Iterable<NauticalActivity> getNauticalActivitiesByWindDirectionCompatibility (int windDirection) {
		// First, retrieve all Weather conditions compatibles with given wind conditions (only direction) :
		Iterable<WeatherCondition> compatiblesWeatherCondition= weatherConditionService.getWeatherConditionsAccordingWindDirection(windDirection);
		// Then get set of Nautical Activity object extracted form the differents WeatherCondition objects
		Set<NauticalActivity> nauticalActivitiesExtracted = getSetOfNauticalActivitiesFromWeatherConditions(compatiblesWeatherCondition);
		return nauticalActivitiesExtracted;
	}
	
	
	public void deleteAllNauticalActivitiesInGivenList (List<NauticalActivity> nauticalActivities_list){
		for (NauticalActivity na : nauticalActivities_list ) {
			nauticalActivityRepository.delete(na);
		}		
	}
	
	/**
	 * 
	 * @param Iterable object of WeatherCondition objects
	 * @return Set of Nautical Activity object extracted form the differents WeatherCondition objects
	 */
	private Set<NauticalActivity> getSetOfNauticalActivitiesFromWeatherConditions (Iterable<WeatherCondition> weatherConditions) {
		Set<NauticalActivity> nauticalActivities = new HashSet<NauticalActivity>();
		if (weatherConditions == null) {
			return Collections.emptySet();
		} else {
			for (WeatherCondition wc : weatherConditions) {
				nauticalActivities.addAll(wc.getNauticalActivities());
			}
			return nauticalActivities;
		}
	}
	
	

}
