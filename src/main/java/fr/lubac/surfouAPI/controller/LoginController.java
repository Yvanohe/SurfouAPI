package fr.lubac.surfouAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.lubac.surfouAPI.service.JWTService;

@RestController
public class LoginController {

	@Autowired
	public JWTService jwtService;
	
	//Constructor injection
//	public LoginController(JWTService jwtService) {
//		this.jwtService = jwtService;
//	}
	
	@PostMapping("/login")
	public String getToken(Authentication authentication) {
		String token = jwtService.generateToken(authentication);
		return token;
	}
}
