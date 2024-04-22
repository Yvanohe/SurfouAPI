package fr.lubac.surfouAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lubac.surfouAPI.model.ActivityDescription;
import fr.lubac.surfouAPI.repository.ActivityDescriptionRepository;

@Service
public class ActivityDescriptionService {
	@Autowired
	private ActivityDescriptionRepository activityDescriptionRepository;
	
	public ActivityDescription saveActivityDescription(ActivityDescription activityDescription) {
		ActivityDescription savedActivityDescription = activityDescriptionRepository.save(activityDescription);
		return savedActivityDescription;	
	}

}
