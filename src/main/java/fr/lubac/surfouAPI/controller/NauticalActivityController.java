package fr.lubac.surfouAPI.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
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

	/**
	 * Read - get all nautical activities (ie. particular compatibilities between spots + activity + weather conditions)
	 * @param params optional request parameters : wforce for wind force (knots kn) and wdir for wind direction (unity ° between 0 and 360) to filter nautical activities bases compatibilities with associated weather conditions
	 * @return An Iterable object of Nautical activity object full filled
	 */
	@GetMapping("/nauticalactivities")
	public Iterable<NauticalActivity> getNauticalActivitiesByWindcompatibility (@RequestParam(required = false) Map<String, String> params ) {		
		 if (params.containsKey("wforce") && params.containsKey("wdir")) {
			return nauticalActivityService.getNauticalActivitiesByWindcompatibility(Integer.valueOf(params.get("wforce")), Integer.valueOf(params.get("wdir")));	
		} else {
			return nauticalActivityService.getNauticalActivities();
		}		
	}

}
