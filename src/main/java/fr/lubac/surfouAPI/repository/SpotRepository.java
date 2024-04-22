package fr.lubac.surfouAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.lubac.surfouAPI.model.Spot;

@Repository
public interface SpotRepository extends CrudRepository<Spot, Integer> {

}
