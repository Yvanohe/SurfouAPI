package fr.lubac.surfouAPI.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import fr.lubac.surfouAPI.model.WeatherCondition;

@Repository
public interface WeatherConditionRepository extends CrudRepository<WeatherCondition, Integer> {

	@Query("from WeatherCondition wc WHERE wc.maxWindForce >=:windForce AND wc.minWindForce <= :windForce")
	Iterable<WeatherCondition> findByWindForce(@Param("windForce") int windForce);	
	
}
