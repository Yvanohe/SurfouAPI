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
		Set<NauticalActivity> compatibleNauticalActivities = new HashSet<NauticalActivity>();
		//1- Retrieve all Weather conditions compatibles with given wind conditions :
		Iterable<WeatherCondition> compatiblesWeatherCondition= weatherConditionService.getWeatherConditionsAccordingWindForceAndDirection(windForce, windDirection);
		if (compatiblesWeatherCondition == null) {
			return Collections.emptySet();
		}
		//2- For each compatiblesWeatherCondition, retrieve Nautical activities : 
		for (WeatherCondition wc :compatiblesWeatherCondition  ) {
			compatibleNauticalActivities.addAll(wc.getNauticalActivities());
		}
		return compatibleNauticalActivities;
	}
	
	public void deleteAllNauticalActivitiesInGivenList (List<NauticalActivity> nauticalActivities_list){
		for (NauticalActivity na : nauticalActivities_list ) {
			nauticalActivityRepository.delete(na);
		}		
	}
	
	

}
