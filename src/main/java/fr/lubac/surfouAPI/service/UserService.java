package fr.lubac.surfouAPI.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fr.lubac.surfouAPI.model.User;
import fr.lubac.surfouAPI.repository.UserRepository;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;
	
	public User saveUser(User user)  {
		if(user.getPassword() == null) {
			throw new IllegalArgumentException("A password must be provided for creating a new user");
		}
		User savedUser = userRepository.save(user);
		return savedUser;
	}
	
	public Optional<User> getUser(int id) {
		return userRepository.findById(id);
	}
	
	public Iterable<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUsername(username);
		if (user.isPresent())
		{
			return user.get();
		} else {
			throw new UsernameNotFoundException("user not found");
		}		
	}

	
}
