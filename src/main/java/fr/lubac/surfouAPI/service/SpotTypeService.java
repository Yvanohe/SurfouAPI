package fr.lubac.surfouAPI.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lubac.surfouAPI.model.SpotType;
import fr.lubac.surfouAPI.repository.SpotTypeRepository;

@Service
public class SpotTypeService {
	
	@Autowired
	private SpotTypeRepository spotTypeRepository;
	
	public SpotType saveSpotType (SpotType spotType) {
		SpotType savedSpotType = spotTypeRepository.save(spotType);		
		return savedSpotType;
	}
	
	public Iterable<SpotType> getSpotTypes () {
		return spotTypeRepository.findAll();
	}
	
	public Optional<SpotType> getSpotType(int id) {
		return spotTypeRepository.findById(id);
	}

}
