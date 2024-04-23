package fr.lubac.surfouAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lubac.surfouAPI.model.NauticalActivity;
import fr.lubac.surfouAPI.repository.NauticalActivityRepository;

@Service
public class NauticalActivityService {
	@Autowired
	private NauticalActivityRepository nauticalActivityRepository;
	
	public NauticalActivity saveNauticalActivity (NauticalActivity nauticalActivity) {
		NauticalActivity savedNauticalActivity = nauticalActivityRepository.save(nauticalActivity);
		return savedNauticalActivity;
	}
	
	public Iterable<NauticalActivity> getNauticalActivities() {
		return nauticalActivityRepository.findAll();
	}
	
	public void deleteAllNauticalActivitiesInGivenList (List<NauticalActivity> nauticalActivities_list){
		for (NauticalActivity na : nauticalActivities_list ) {
			nauticalActivityRepository.delete(na);
		}
		
	}

}
