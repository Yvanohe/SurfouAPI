package fr.lubac.surfouAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lubac.surfouAPI.model.ActivityDescription;
import fr.lubac.surfouAPI.service.ActivityDescriptionService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Nautical activity description")
@RestController
public class ActivityDescriptionController {
	
	@Autowired
	private ActivityDescriptionService activityDescriptionService;
	
	@PostMapping("/activitiesdescriptions")
	public ActivityDescription createActivity (@RequestBody ActivityDescription activityDescription) {
		return activityDescriptionService.saveActivityDescription(activityDescription);
	}
	
	/**
	 *  Read - get all activities descriptions
	 * @return An Iterable object of ActivityDescription objects full filled
	 */
	@GetMapping("/activitiesdescriptions")
	public Iterable<ActivityDescription> getActivityDescriptions () {
		return activityDescriptionService.getActivityDescriptions();
	}

}
