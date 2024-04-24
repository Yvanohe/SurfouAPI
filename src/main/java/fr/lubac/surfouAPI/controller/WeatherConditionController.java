package fr.lubac.surfouAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lubac.surfouAPI.model.WeatherCondition;
import fr.lubac.surfouAPI.service.WeatherConditionService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Weather condition")
@RestController
public class WeatherConditionController {
	
	@Autowired
	private WeatherConditionService weatherConditionService;
	
	
	/**
	 * A new weather conditions to database
	 * @param WeatherCondition object
	 * @return saved WeatherCondition object
	 */
	@PostMapping("/conditions")
	public WeatherCondition createWeatherCondition (@RequestBody WeatherCondition weatherCondition) {
		return weatherConditionService.saveWeatherCondition(weatherCondition);
	}
	
	@GetMapping("/conditions")
	public Iterable<WeatherCondition> getWeatherConditions() {
		return weatherConditionService.getWeatherConditions();
	}
	
	
}
