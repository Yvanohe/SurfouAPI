package fr.lubac.surfouAPI.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lubac.surfouAPI.model.Spot;
import fr.lubac.surfouAPI.model.User;
import fr.lubac.surfouAPI.service.SpotService;
import fr.lubac.surfouAPI.service.UserService;

@RestController
public class SpotController {
	@Autowired
	private SpotService spotService;
	
	@Autowired
	private UserService userService;
	
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
	 * Delete a spot
	 * @param id
	 */
	@DeleteMapping("/spots/{id}")
	public void deleteSpot(@PathVariable("id") int id) {
		spotService.deleteSpot(id);
	}
	
	/**
	 * Get all spots
	 * @return - An Iterable object of Spot objects
	 */
	@GetMapping("/spots")
	public Iterable<Spot> getSpots() {
		return spotService.getSpots();
	}
	/**
	 * Read - get spot by id
	 * @param id
	 * @return selected spot
	 */
	@GetMapping("/spots/{id}")
	public Spot getSpot (@PathVariable("id") int id) {
		Optional<Spot> spot = spotService.getSpot(id);
		if (spot.isPresent()) {
			return spot.get();
		} else {
			return null;
		}
	}
	
	/**
	 * read - get user who created the spot
	 * @param id_spot
	 * @return user
	 */
	@GetMapping("/spots/{id}/creatoruser")
	public User getSpotCreatorUser (@PathVariable("id") int id_spot) {
		Spot spot = this.getSpot(id_spot);
		User spotCreatorUser = null;
		if (spot != null) {
			Optional<User> user = userService.getUser(spot.getCreatorUser().getId());
			if (user.isPresent()) {
				spotCreatorUser= user.get();
			}
		} 		
		return spotCreatorUser;		
	}	
}
