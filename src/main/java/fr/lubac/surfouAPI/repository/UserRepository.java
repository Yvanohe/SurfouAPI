package fr.lubac.surfouAPI.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import fr.lubac.surfouAPI.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
