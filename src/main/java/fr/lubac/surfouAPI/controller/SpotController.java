package fr.lubac.surfouAPI.controller;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.lubac.surfouAPI.model.Spot;
import fr.lubac.surfouAPI.model.User;
import fr.lubac.surfouAPI.service.SpotService;
import fr.lubac.surfouAPI.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Spot")
@RestController
@RequestMapping("/spots")
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
	@PostMapping
	public ResponseEntity<Spot> createSpot (@RequestBody Spot spot) {
		Spot newSpotAdded = spotService.createSpot(spot);
		// if spot not added or null : return 204 No Content
		if (newSpotAdded == null){
			return ResponseEntity.noContent().build();			
		} else { // return 201 and URI to this new resource added
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(newSpotAdded.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}
	}
	
	/**
	 * Delete a spot
	 * @param id
	 */
	@DeleteMapping("/{id}")
	public void deleteSpot(@PathVariable("id") int id) {
		spotService.deleteSpot(id);
	}
	
	/**
	 * Get all spots
	 * @return - An Iterable object of Spot objects
	 */
	@GetMapping
	public Iterable<Spot> getSpots() {
		return spotService.getSpots();
	}
	/**
	 * Read - get spot by id
	 * @param id
	 * @return selected spot
	 */
	@GetMapping("/{id}")
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
	@GetMapping("/{id}/creatoruser")
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
