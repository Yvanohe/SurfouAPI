package fr.lubac.surfouAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lubac.surfouAPI.model.Spot;
import fr.lubac.surfouAPI.service.SpotService;

@RestController
public class SpotController {
	@Autowired
	private SpotService spotService;
	
	/**
	 * Add a new spot in database
	 * @param spot object
	 * @return saved Spot object 
	 */
	@PostMapping("/spots")
	public Spot createSpot (@RequestBody Spot spot) {
		return spotService.saveSpot(spot);
	}
	
	/**
	 * Get all spots
	 * @return - An Iterable object of Spot objects
	 */
	@GetMapping("/spots")
	public Iterable<Spot> getSpots() {
		return spotService.getSpots();
	}
	
}
