package fr.lubac.surfouAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.lubac.surfouAPI.model.User;
import fr.lubac.surfouAPI.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user)  {
		User savedUser = userRepository.save(user);
		return savedUser;
	}
	
	public Optional<User> getUser(int id) {
		return userRepository.findById(id);
	}
	
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}

}
