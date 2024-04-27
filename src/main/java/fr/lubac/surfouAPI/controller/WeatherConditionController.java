package fr.lubac.surfouAPI.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lubac.surfouAPI.model.WeatherCondition;
import fr.lubac.surfouAPI.service.WeatherConditionService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Weather condition")
@RestController
@RequestMapping("/conditions")
public class WeatherConditionController {
	
	@Autowired
	private WeatherConditionService weatherConditionService;
	
	
	/**
	 * A new weather conditions to database
	 * @param WeatherCondition object
	 * @return saved WeatherCondition object
	 */
	@PostMapping
	public WeatherCondition createWeatherCondition (@RequestBody WeatherCondition weatherCondition) {
		return weatherConditionService.saveWeatherCondition(weatherCondition);
	}
	
	@GetMapping
	public Iterable<WeatherCondition> getWeatherConditions() {
		return weatherConditionService.getWeatherConditions();
	}	
	
	
}
