package fr.lubac.surfouAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.lubac.surfouAPI.model.NauticalActivity;

@Repository
public interface NauticalActivityRepository extends CrudRepository<NauticalActivity, Integer> {
	
	

}
