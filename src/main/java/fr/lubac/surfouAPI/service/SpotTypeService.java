package fr.lubac.surfouAPI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lubac.surfouAPI.model.SpotType;
import fr.lubac.surfouAPI.repository.SpotTypeRepository;

@Service
public class SpotTypeService {
	
	@Autowired
	private SpotTypeRepository spotTypeRepository;
	
	public SpotType saveSpotType (SpotType spotType) {
		SpotType savedSpotType = spotTypeRepository.save(saveSpotType(spotType));		
		return savedSpotType;
	}

}
