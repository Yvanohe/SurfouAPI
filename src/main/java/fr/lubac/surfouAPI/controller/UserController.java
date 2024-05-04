package fr.lubac.surfouAPI.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lubac.surfouAPI.model.User;
import fr.lubac.surfouAPI.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name="User")
@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	// CreateUser to be put in AuthController (/auth/register)
//	/**
//	 * Add a new suser in database
//	 * @param user object
//	 * @return saved user object 
//	 */
//	@PostMapping
//	public ResponseEntity<?> createUser(@RequestBody User user) {
//		try {
//		User newUserAdded = userService.saveUser(user);
//			if (newUserAdded == null) {
//				return ResponseEntity.noContent().build();
//			} else {
//				URI location = ServletUriComponentsBuilder
//						.fromCurrentRequest()
//						.path("/{id}")
//						.buildAndExpand(newUserAdded.getId())
//						.toUri();
//				return ResponseEntity.created(location).build();
//			}
//		} catch (IllegalArgumentException ex ) {
//			return ResponseEntity.badRequest().body("Error : " + ex.getMessage());
//		}
//	}
	/**
	 * Read - get all users
	 * @return An Iterable object of User objects full filled
	 */
	@GetMapping
	public Iterable<User> getUsers() {
		return userService.getUsers();
	}
	
	/**
	 * Read - get user by id
	 * @param id
	 * @return selected user
	 */
	@GetMapping("/{id}")
	public User getUser (@PathVariable("id") int id) {
		Optional<User> user = userService.getUser(id);
		if (user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
		
	}

}
