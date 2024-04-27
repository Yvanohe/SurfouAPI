package fr.lubac.surfouAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.lubac.surfouAPI.model.Spot;
import fr.lubac.surfouAPI.model.User;
import fr.lubac.surfouAPI.repository.SpotRepository;
import fr.lubac.surfouAPI.repository.UserRepository;

@Service
public class SpotService {
	@Autowired
	private SpotRepository spotRepository;
	
	
	private NauticalActivityService nauticalActivityService;
	@Autowired
	public void setNauticalActivityService(@Lazy NauticalActivityService nauticalActivityService) {
	        this.nauticalActivityService = nauticalActivityService;
	 }
	
	@Autowired
	private UserRepository userRepository;
	
	public Spot createSpot(Spot spot) {
		//First, only create spot : the id must be null as the CRUDRepository save method check if ID exist for choosing updating or creating new object in database
		spot.deleteId();
		// 2- verify presence of creatorUser parameter :
		if (isSpotCreatorUserexists(spot) ) {
			return spotRepository.save(spot);
		} else {
			// handle the case where the user does not exist.
            return null; 
		}		      
	}	
	
	public Iterable<Spot> getSpots() {
		return spotRepository.findAll();
	}
	
	public Optional<Spot> getSpot(int id) {
		return spotRepository.findById(id);
	}
	
	@Transactional
	public void deleteSpot(int id) {
		//ADD EXCEPTIONS HANDLING
		//get the spot object :
		Optional<Spot> spot = spotRepository.findById(id);
		//Need to handle deletion of spot occurence in 2 joint table (Nautical_activities and users_spot_bookmarked) before deleting spot
		if (spot.isPresent()) {
			Spot spotToDelete = spot.get();
			//1 -Delete occurence of spots in associations table "Nautical_Activity"
			nauticalActivityService.deleteAllNauticalActivitiesInGivenList(spotToDelete.getNauticalActivities());
			//2 - Second delete reference of this spot in the users_spot_bookmarked joint table (implicity managed by hibernate) :
			for (User user : spotToDelete.getBookmarkingUsers()) {
		        user.getBookmarkedSpots().remove(spotToDelete);
		        userRepository.save(user);
		    }
			//3 - Finally delete spot :	
			spotRepository.delete(spotToDelete);
		} else {
			// Here  handle if spot doesn't exists
		}
	}
	
	public boolean isSpotCreatorUserexists (Spot spot) {
		boolean userExists= false;
		
		if (spot.getCreatorUser()!=null ) {
			Optional<User> creatorUser = userRepository.findById(spot.getCreatorUser().getId());
	        if (creatorUser.isPresent()) {
	        	userExists = true;
	        } 
		}
		return userExists;		
	}

}
