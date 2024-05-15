package fr.lubac.surfouAPI.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.lubac.surfouAPI.model.WeatherCondition;
import fr.lubac.surfouAPI.service.WeatherConditionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

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
	public ResponseEntity<WeatherCondition> createWeatherCondition (@Valid @RequestBody WeatherCondition weatherCondition) {
		WeatherCondition newWeatherConditionAdded = weatherConditionService.saveWeatherCondition(weatherCondition);
		if (newWeatherConditionAdded == null) {
			return ResponseEntity.noContent().build();	
		} else {
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(newWeatherConditionAdded.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}	
	}
	
	@GetMapping
	public Iterable<WeatherCondition> getWeatherConditions() {
		return weatherConditionService.getWeatherConditions();
	}	
	
	@GetMapping("/{id}")
	public Optional<WeatherCondition> getWeatherCondition(@PathVariable("id") int id) {
		return weatherConditionService.getWeatherCondition(id);
	}
	
}
