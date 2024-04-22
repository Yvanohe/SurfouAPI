package fr.lubac.surfouAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lubac.surfouAPI.model.Spot;
import fr.lubac.surfouAPI.model.User;
import fr.lubac.surfouAPI.repository.SpotRepository;
import fr.lubac.surfouAPI.repository.UserRepository;

@Service
public class SpotService {
	@Autowired
	private SpotRepository spotRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	public Spot saveSpot(Spot spot) {
		Optional<User> creatorUser = userRepository.findById(spot.getCreatorUser().getId());
        if (creatorUser.isPresent()) {
            spot.setCreatorUser(creatorUser.get()); // Set the creator user before saving
            return spotRepository.save(spot);
        } else {
            // handle the case where the user does not exist.
            // This could be logging, throwing an exception, or any other business logic.
            return null; 
        }
	}	
	

}
