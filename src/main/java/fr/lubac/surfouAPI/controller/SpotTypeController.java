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

import fr.lubac.surfouAPI.model.SpotType;
import fr.lubac.surfouAPI.service.SpotTypeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@Tag(name="Spot type")
@RestController
@RequestMapping("/spottypes")
public class SpotTypeController {
	
	@Autowired
	private SpotTypeService spotTypeService;

	/**
	 * Add a new spot type in database
	 * @param SpotType object
	 * @return saved SpotType object 
	 */
	@PostMapping
	public ResponseEntity<SpotType> createSpotType (@Valid @RequestBody SpotType spotType) {
		SpotType newSpotTypeAdded = spotTypeService.saveSpotType(spotType);
		if (newSpotTypeAdded == null) {
			return ResponseEntity.noContent().build();
		} else {
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(newSpotTypeAdded.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}		
	}
	
	/**
	 * Read - get all spot types
	 * @return An Iterable object of SpotType object full filled
	 */
	@GetMapping
	public Iterable<SpotType> getSpotTypes() {
		return spotTypeService.getSpotTypes();
	}
	
	@GetMapping("/{id}")
	public Optional<SpotType> getSpotTYpe(@PathVariable("id") int id) {
		return spotTypeService.getSpotType(id);
	}
}
