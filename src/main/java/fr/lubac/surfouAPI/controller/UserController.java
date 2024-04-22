package fr.lubac.surfouAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.lubac.surfouAPI.model.User;
import fr.lubac.surfouAPI.service.UserService;

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
		System.out.println(user.toString());
		return userService.saveUser(user);
	}

}
