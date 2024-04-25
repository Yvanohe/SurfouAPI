package fr.lubac.surfouAPI.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lubac.surfouAPI.model.User;
import fr.lubac.surfouAPI.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="User")
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	/**
	 * Add a new suser in database
	 * @param user object
	 * @return saved user object 
	 */
	@PostMapping("/users")
	public User createUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	/**
	 * Read - get all users
	 * @return An Iterable object of User objects full filled
	 */
	@GetMapping("/users")
	public Iterable<User> getUsers() {
		return userService.getUsers();
	}
	
	/**
	 * Read - get user by id
	 * @param id
	 * @return selected user
	 */
	@GetMapping("/users/{id}")
	public User getUser (@PathVariable("id") int id) {
		Optional<User> user = userService.getUser(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
		
	}

}
