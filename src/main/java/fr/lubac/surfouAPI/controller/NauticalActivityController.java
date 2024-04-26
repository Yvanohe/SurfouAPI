package fr.lubac.surfouAPI.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.lubac.surfouAPI.model.NauticalActivity;
import fr.lubac.surfouAPI.service.NauticalActivityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="Nautical activity", description="api for nautical activities associated with the location (spot) and compatible weather conditions")
@RestController
@RequestMapping("/nauticalactivities")
public class NauticalActivityController {
	
	@Autowired
	private NauticalActivityService nauticalActivityService;
	
	/**
	 * Add a new nautical activity in database
	 * @param NauticalActivity object
	 * @return saved NauticalActivity object 
	 */
	@PostMapping
	public NauticalActivity createNauticalActivity (@RequestBody NauticalActivity nauticalActivity) {
		return nauticalActivityService.saveNauticalActivity(nauticalActivity);
	}	

	/**
	 * Read - get all nautical activities (ie. particular compatibilities between spots + activity + weather conditions)
	 * @param params optional request parameters : wforce for wind force (knots kn) and wdir for wind direction (unity ° between 0 and 360) to filter nautical activities bases compatibilities with associated weather conditions
	 * @return An Iterable object of Nautical activity object full filled
	 */
	 @Operation(
	            summary = "Fetch all nautical activities",
	            description = "Fetch all nautical activities and their data (spot, activity description, weather xondition) from database. Possibility to filter by weather condition.",
	            parameters = {
	            		@Parameter(name ="wforce", required=false, description = "Wind force in Knots to filter nautical activities compatible with this wind force"),
	            		@Parameter(name ="wdir", required=false, description = "Wind direction in degree (between 0 & 360°) to filter nautical activities compatible with this wind direction")
	            })
	@GetMapping
	public Iterable<NauticalActivity> getNauticalActivitiesByWindcompatibility (@RequestParam(required = false) Map<String, String> params ) {		
		 if (params.containsKey("wforce") && params.containsKey("wdir")) {
			return nauticalActivityService.getNauticalActivitiesByWindcompatibility(Integer.valueOf(params.get("wforce")), Integer.valueOf(params.get("wdir")));	
		}  else if (params.containsKey("wforce") && !params.containsKey("wdir")) {
			return nauticalActivityService.getNauticalActivitiesByWindForcecompatibility(Integer.valueOf(params.get("wforce")));			
		}  else if (!params.containsKey("wforce") && params.containsKey("wdir")) {
			return nauticalActivityService.getNauticalActivitiesByWindDirectionCompatibility(Integer.valueOf(params.get("wdir")));
		} else {
			return nauticalActivityService.getNauticalActivities();
		}	
			
	}

}
