package fr.lubac.surfouAPI.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.lubac.surfouAPI.model.NauticalActivity;

@Repository
public interface NauticalActivityRepository extends CrudRepository<NauticalActivity, Integer> {
	
	//@Query("from NauticalActivity na WHERE na.weatherCondition=:weatherConditionId")
	//Iterable<NauticalActivity> findByWeatherConditionId(@Param("weatherConditionId") int id);

	@Query("from NauticalActivity na WHERE na.spot.id=:spotID AND na.activityDescription.id=:activityDescriptionID AND na.weatherCondition.id=:weatherConditionID")
	Optional<NauticalActivity> findByIDs(@Param("spotID") int spotId, @Param("activityDescriptionID") int activityDescriptionId, @Param("weatherConditionID") int weatherConditionId  );
}
