package fr.lubac.surfouAPI.service;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lubac.surfouAPI.exceptions.MessageReader;
import fr.lubac.surfouAPI.model.ActivityDescription;
import fr.lubac.surfouAPI.model.NauticalActivity;
import fr.lubac.surfouAPI.model.Spot;
import fr.lubac.surfouAPI.model.WeatherCondition;
import fr.lubac.surfouAPI.repository.NauticalActivityRepository;
import jakarta.persistence.EntityExistsException;

@Service
public class NauticalActivityService {
	@Autowired
	private NauticalActivityRepository nauticalActivityRepository;
	
	@Autowired
	private WeatherConditionService weatherConditionService;	
	@Autowired
	private SpotService spotService;
	@Autowired
	private ActivityDescriptionService activityDescriptionService;
	
	@Autowired
	private MessageReader messageReader;

	/**
	 * We can create a NauticalActivity association by 3 ways :
	 * -1/ In request body just specify the id object defining the 3 ids needed (spot, nautical description and weather conditions). ex : {"id": {"spotID":x, "activityDescriptionID":y, "weatherConditionID":z}}
	 * -2/ In request body specify the 3 objects spot/ActivityDescription/WeatherCondition with existing id. ex: {"spot":{"id":x},"activityDescription":{"id":y},"weatherCondition":{"id":z}}
	 * -3/ In request body specify the 3 objects spot/ActivityDescription/WeatherCondition which are new and will be created alongside the NauticalActivity association. Theses new object should be well described with mandatory attributes.
	 * @param nauticalActivity
	 * @return
	 */
	@Transactional
	public NauticalActivity saveNauticalActivity (NauticalActivity nauticalActivity) {
		//For Spot, ActivityDescription and WeatherCondition, check if there is at least an Id provided or an object :
		if (nauticalActivity.getId().getSpotID() == 0 && nauticalActivity.getSpot() == null ) {
			//throw new IllegalArgumentException("Nautical activity should have a spot object or a spotID provided");
			throw new IllegalArgumentException(messageReader.getMessageErreur(ErrorCodesServices.NA_SPOT_OR_SPOTID_REQUIRED_RULE, Locale.FRENCH));
		}
		if (nauticalActivity.getId().getActivityDescriptionID() == 0 && nauticalActivity.getActivityDescription() == null ) {
			throw new IllegalArgumentException("Nautical activity should have a activityDescription object or a activityDescriptionID provided");
		}
		if (nauticalActivity.getId().getWeatherConditionID() == 0 && nauticalActivity.getWeatherCondition() == null ) {
			throw new IllegalArgumentException("Nautical activity should have a weatherCondition object or a weatherConditionID provided");
		}
		
		
		// SPOT
		int idSpotToRetrieveIfExists;
		//For each object check if both ID and object are provided :
		if (nauticalActivity.getId().getSpotID() != 0 && nauticalActivity.getSpot() != null) {
			// Both are provided, check if coherents and if coherents, retrieve the object from database if exists.
			if (nauticalActivity.getId().getSpotID() == nauticalActivity.getSpot().getId() ) {
				idSpotToRetrieveIfExists = nauticalActivity.getSpot().getId();
			} else {
				throw new IllegalArgumentException("spotID and spot object's ids provided are not coherents");				
			}	
			//if only one is provided :		
		} else {			
			if(nauticalActivity.getId().getSpotID() == 0) {
				idSpotToRetrieveIfExists = nauticalActivity.getSpot().getId();
			} else {
				idSpotToRetrieveIfExists = nauticalActivity.getId().getSpotID();
				// In this case already check if spot exists and if not, throw an exception (there will be no spot to add in Nautical Activity)
				if (getSpotIfExists(idSpotToRetrieveIfExists) == null) {
					throw new IllegalArgumentException("spotID provided doesn't exists in database. Provide an existing one or define a new Spot object");
				}
			}
		}
		// ACTIVITY DESCRIPTION
		int idActivityDescriptionToRetrieveIfExists;
		if (nauticalActivity.getId().getActivityDescriptionID() != 0 && nauticalActivity.getActivityDescription()!= null) {
			if (nauticalActivity.getId().getActivityDescriptionID() == nauticalActivity.getActivityDescription().getId()) {
				idActivityDescriptionToRetrieveIfExists = nauticalActivity.getActivityDescription().getId();
			} else {
				throw new IllegalArgumentException("activityDescriptionID and activityDescription object's ids provided are not coherents");
			}
		} else {
			if(nauticalActivity.getId().getActivityDescriptionID() == 0) {
				idActivityDescriptionToRetrieveIfExists = nauticalActivity.getActivityDescription().getId();
			} else {				
				idActivityDescriptionToRetrieveIfExists =nauticalActivity.getId().getActivityDescriptionID();
				if (getActivityDescriptionIfexists(idActivityDescriptionToRetrieveIfExists)==null) {
					throw new IllegalArgumentException("activityDescriptionID provided doesn't exists in database. Provide an existing one or define a new ActivityDescription object");
				}
			}
		}
		//WEATHER CONDITION
		int idWeatherConditionToRetrieveIfExists;
		if (nauticalActivity.getId().getWeatherConditionID() != 0 && nauticalActivity.getWeatherCondition()!= null) {
			if (nauticalActivity.getId().getWeatherConditionID() == nauticalActivity.getWeatherCondition().getId()) {
				idWeatherConditionToRetrieveIfExists = nauticalActivity.getWeatherCondition().getId();
			} else {
				throw new IllegalArgumentException("weatherConditionID and weatherCondition object's ids provided are not coherents");
			}
		} else {
			if(nauticalActivity.getId().getWeatherConditionID() == 0) {
				idWeatherConditionToRetrieveIfExists = nauticalActivity.getWeatherCondition().getId();
			} else {
				idWeatherConditionToRetrieveIfExists =  nauticalActivity.getId().getWeatherConditionID();
				if (getWeatherConditionIfExists(idWeatherConditionToRetrieveIfExists) == null) {
					throw new IllegalArgumentException("weatherConditionID provided doesn't exists in database. Provide an existing one or define a new ActivityDescription object");
				}
			}
		}	
		//Check if association already exists (no update for create method):
		Optional<NauticalActivity> na = nauticalActivityRepository.findByIDs(idSpotToRetrieveIfExists, idActivityDescriptionToRetrieveIfExists, idWeatherConditionToRetrieveIfExists);
		if (na.isPresent()) {
			throw new EntityExistsException("The spot/activityDescription/weatherCondition association provided already exists");
		}
		
		//Retrieve the different objets by the Id (because the existing object will not be updated in this create method)
		Spot spot = getSpotIfExists(idSpotToRetrieveIfExists);
		if(spot != null) {
			nauticalActivity.setSpot(spot);
		}
		ActivityDescription ad = getActivityDescriptionIfexists(idActivityDescriptionToRetrieveIfExists);
		if (ad != null) {
			nauticalActivity.setActivityDescription(ad);
		}
		WeatherCondition wc = getWeatherConditionIfExists(idWeatherConditionToRetrieveIfExists);
		if (wc != null) {
			nauticalActivity.setWeatherCondition(wc);
		}
		// finally saving in database
		NauticalActivity savedNauticalActivity = nauticalActivityRepository.save(nauticalActivity);
	
		return savedNauticalActivity;
	}
	
	public Iterable<NauticalActivity> getNauticalActivities() {
		return nauticalActivityRepository.findAll();
	}
	
	public Iterable<NauticalActivity> getNauticalActivitiesByWindcompatibility(int windForce, int windDirection) {
		//First - Retrieve all Weather conditions compatibles with given wind conditions (force and direction) :
		Iterable<WeatherCondition> compatiblesWeatherCondition= weatherConditionService.getWeatherConditionsAccordingWindForceAndDirection(windForce, windDirection);
		//Then get set of Nautical Activity object extracted form the differents WeatherCondition objects
		Set<NauticalActivity> nauticalActivitiesExtracted = getSetOfNauticalActivitiesFromWeatherConditions(compatiblesWeatherCondition);
		return nauticalActivitiesExtracted;
	}
	
	public Iterable<NauticalActivity> getNauticalActivitiesByWindForcecompatibility (int windForce) {
		// First, retrieve all Weather conditions compatibles with given wind conditions (only force) :
		Iterable<WeatherCondition> compatiblesWeatherCondition= weatherConditionService.getWeatherConditionsAccordingWindForce(windForce);
		// Then get set of Nautical Activity object extracted form the differents WeatherCondition objects
		Set<NauticalActivity> nauticalActivitiesExtracted = getSetOfNauticalActivitiesFromWeatherConditions(compatiblesWeatherCondition);
		return nauticalActivitiesExtracted;
	}
	
	public Iterable<NauticalActivity> getNauticalActivitiesByWindDirectionCompatibility (int windDirection) {
		// First, retrieve all Weather conditions compatibles with given wind conditions (only direction) :
		Iterable<WeatherCondition> compatiblesWeatherCondition= weatherConditionService.getWeatherConditionsAccordingWindDirection(windDirection);
		// Then get set of Nautical Activity object extracted form the differents WeatherCondition objects
		Set<NauticalActivity> nauticalActivitiesExtracted = getSetOfNauticalActivitiesFromWeatherConditions(compatiblesWeatherCondition);
		return nauticalActivitiesExtracted;
	}
	
	
	public void deleteAllNauticalActivitiesInGivenList (List<NauticalActivity> nauticalActivities_list){
		for (NauticalActivity na : nauticalActivities_list ) {
			nauticalActivityRepository.delete(na);
		}		
	}
	
	/**
	 * 
	 * @param Iterable object of WeatherCondition objects
	 * @return Set of Nautical Activity object extracted form the differents WeatherCondition objects
	 */
	private Set<NauticalActivity> getSetOfNauticalActivitiesFromWeatherConditions (Iterable<WeatherCondition> weatherConditions) {
		Set<NauticalActivity> nauticalActivities = new HashSet<NauticalActivity>();
		if (weatherConditions == null) {
			return Collections.emptySet();
		} else {
			for (WeatherCondition wc : weatherConditions) {
				nauticalActivities.addAll(wc.getNauticalActivities());
			}
			return nauticalActivities;
		}
	}
	
	private Spot getSpotIfExists(int spotId) {
		Optional<Spot> spot = spotService.getSpot(spotId);
		if(spot.isPresent()) {
			return spot.get();
		} else {
			return null;
		}
	}
	
	private ActivityDescription getActivityDescriptionIfexists (int aDid) {
		Optional<ActivityDescription> ad = activityDescriptionService.getActivityDescription(aDid);
		if (ad.isPresent()) {			
			return(ad.get());
		} else {
			return null;
		}
	}
	
	private WeatherCondition getWeatherConditionIfExists (int wcId) {
		Optional<WeatherCondition> wc = weatherConditionService.getWeatherCondition(wcId);
		if (wc.isPresent()) {
			return wc.get();
		} else {
			return null;
		}
	}
}
