package fr.lubac.surfouAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lubac.surfouAPI.model.ActivityDescription;
import fr.lubac.surfouAPI.service.ActivityDescriptionService;

@RestController
public class ActivityDescriptionController {
	
	@Autowired
	private ActivityDescriptionService activityDescriptionService;
	
	@PostMapping("/activities")
	public ActivityDescription createActivity (@RequestBody ActivityDescription activityDescription) {
		return activityDescriptionService.saveActivityDescription(activityDescription);
	}

}
