package fr.lubac.surfouAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lubac.surfouAPI.model.NauticalActivity;
import fr.lubac.surfouAPI.service.NauticalActivityService;

@RestController
public class NauticalActivityController {
	
	@Autowired
	private NauticalActivityService nauticalActivityService;
	
	/**
	 * Add a new nautical activity in database
	 * @param NauticalActivity object
	 * @return saved NauticalActivity object 
	 */
	@PostMapping("/nauticalactivities")
	public NauticalActivity createNauticalActivity (@RequestBody NauticalActivity nauticalActivity) {
		return nauticalActivityService.saveNauticalActivity(nauticalActivity);
	}
	

}
