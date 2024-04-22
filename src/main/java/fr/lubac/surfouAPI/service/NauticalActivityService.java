package fr.lubac.surfouAPI.service;

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

}
