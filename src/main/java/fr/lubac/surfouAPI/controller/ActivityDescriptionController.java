package fr.lubac.surfouAPI.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import fr.lubac.surfouAPI.model.ActivityDescription;
import fr.lubac.surfouAPI.service.ActivityDescriptionService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Nautical activity description")
@RestController
@RequestMapping("/activitiesdescriptions")
public class ActivityDescriptionController {
	
	@Autowired
	private ActivityDescriptionService activityDescriptionService;
	
	@PostMapping
	public ResponseEntity<ActivityDescription> createActivity (@RequestBody ActivityDescription activityDescription) {
		ActivityDescription newADescriptionAdded = activityDescriptionService.saveActivityDescription(activityDescription);
		// if activity not added or null : return 204 No Content
		if(newADescriptionAdded == null) {
			return ResponseEntity.noContent().build();
		} else {
			URI location = ServletUriComponentsBuilder
					.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(newADescriptionAdded.getId())
					.toUri();
			return ResponseEntity.created(location).build();
		}
	}
	
	/**
	 *  Read - get all activities descriptions
	 * @return An Iterable object of ActivityDescription objects full filled
	 */
	@GetMapping
	public Iterable<ActivityDescription> getActivityDescriptions () {
		return activityDescriptionService.getActivityDescriptions();
	}

}
