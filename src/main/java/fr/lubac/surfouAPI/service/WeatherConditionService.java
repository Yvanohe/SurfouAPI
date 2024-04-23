package fr.lubac.surfouAPI.service;

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
}
