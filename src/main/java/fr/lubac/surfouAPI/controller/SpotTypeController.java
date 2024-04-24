package fr.lubac.surfouAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lubac.surfouAPI.model.SpotType;
import fr.lubac.surfouAPI.service.SpotTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Spot type")
@RestController
public class SpotTypeController {
	
	@Autowired
	private SpotTypeService spotTypeService;

	/**
	 * Add a new spot type in database
	 * @param SpotType object
	 * @return saved SpotType object 
	 */
	@PostMapping("/spottypes")
	public SpotType createSpotType (@RequestBody SpotType spotType) {
		return spotTypeService.saveSpotType(spotType);
	}
	
	/**
	 * Read - get all spot types
	 * @return An Iterable object of SpotType object full filled
	 */
	@GetMapping("/spottypes")
	public Iterable<SpotType> getSpotTypes() {
		return spotTypeService.getSpotTypes();
	}
}
