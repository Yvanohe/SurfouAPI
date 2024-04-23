package fr.lubac.surfouAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lubac.surfouAPI.model.SpotType;
import fr.lubac.surfouAPI.service.SpotTypeService;

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
}
