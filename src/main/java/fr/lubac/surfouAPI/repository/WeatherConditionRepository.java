package fr.lubac.surfouAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.lubac.surfouAPI.model.WeatherCondition;

@Repository
public interface WeatherConditionRepository extends CrudRepository<WeatherCondition, Integer> {

}
